package me.hatter.tools.jsspserver.filter;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.hatter.tools.jsspserver.action.Action;
import me.hatter.tools.jsspserver.action.Action.DoAction;
import me.hatter.tools.resourceproxy.commons.resource.Resource;
import me.hatter.tools.resourceproxy.jsspexec.JsspExecutor;
import me.hatter.tools.resourceproxy.jsspexec.JsspReader;
import me.hatter.tools.resourceproxy.jsspexec.jsspreader.ExplainedJsspReader;
import me.hatter.tools.resourceproxy.jsspexec.utl.BufferWriter;
import me.hatter.tools.resourceproxy.jsspserver.util.ContentTypes;
import me.hatter.tools.resourceproxy.jsspserver.util.HttpConstants;
import me.hatter.tools.resourceproxy.jsspserver.util.JsspResource;
import me.hatter.tools.resourceproxy.jsspserver.util.JsspResourceManager;
import winstone.WinstoneResponse;

public class JSSPFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                             ServletException {
        request.setCharacterEncoding(FilterUtil.DEFAULT_CHARACTER_ENCODING);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String fpath = httpRequest.getServletPath();
        if (fpath.toLowerCase().endsWith(".jssp")) {
            JsspResource jsspResource = JsspResourceManager.getJsspResource(FilterUtil.getResource(fpath));

            JsspReader jsspReader = new ExplainedJsspReader() {

                public String readExplained(String path) {
                    Resource resource = FilterUtil.getResource(path);
                    if (!resource.exists()) {
                        throw new RuntimeException("Resource not found: " + path);
                    }
                    JsspResource jsspResource = JsspResourceManager.getJsspResource(resource);
                    return jsspResource.getExplainedContent(FilterUtil.JSSP_DEBUG);
                }
            };

            if (jsspResource.exists()) {
                System.out.println("[INFO] Found jssp resource: " + jsspResource.getResource());

                Map<String, Object> context = new HashMap<String, Object>();
                String jsspAction = httpRequest.getParameter(Action.JSSP_ACTION);
                if (jsspAction != null) {
                    try {
                        Class<?> jsspActionClazz = Class.forName(jsspAction);
                        System.out.println("[INFO] Found jssp action: " + jsspActionClazz);
                        if (Action.class.isAssignableFrom(jsspActionClazz)) {
                            Action a = ((Action) jsspActionClazz.newInstance());
                            context = a.doAction(httpRequest, httpResponse);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                if (httpResponse instanceof WinstoneResponse) {
                    int status = ((WinstoneResponse) httpResponse).getStatus();
                    if ((status == HttpServletResponse.SC_MOVED_PERMANENTLY)
                        || (status == HttpServletResponse.SC_MOVED_TEMPORARILY)) {
                        return; // redirected
                    }
                }

                String explainedContent = jsspResource.getExplainedContent(FilterUtil.JSSP_DEBUG);

                BufferWriter bw = new BufferWriter();
                Map<String, Object> addContext = new HashMap<String, Object>();
                addContext.put("request", httpRequest);
                addContext.put("response", httpResponse);
                addContext.put("action", new DoAction(httpRequest, httpResponse, context));

                JsspExecutor.executeExplained(new StringReader(explainedContent), context, addContext, jsspReader, bw,
                                              jsspResource.getResource());

                httpResponse.setCharacterEncoding(ContentTypes.UTF8_CHARSET);
                httpResponse.setStatus(HttpConstants.STATUS_SUCCESS);
                httpResponse.setContentType(ContentTypes.HTML_AND_UTF8);
                httpResponse.getWriter().print(bw.getBufferedString());
            } else {
                // response.set
                httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
                httpResponse.setContentType("text/plain");
                httpResponse.getWriter().print("Resource not found: " + fpath);
            }
        } else {
            chain.doFilter(httpRequest, response);
        }
    }

    public void destroy() {
    }

}