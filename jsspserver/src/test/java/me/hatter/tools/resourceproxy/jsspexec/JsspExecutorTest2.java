package me.hatter.tools.resourceproxy.jsspexec;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import me.hatter.tools.commons.resource.impl.FileResource;
import me.hatter.tools.resourceproxy.jsspexec.util.BufferWriter;

public class JsspExecutorTest2 {

    public static void main(String[] args) throws Exception {
        JsspExecutor.initJsspWork();

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("aa", new ArrayList<String>(Arrays.asList("1", "3", "5")));
        Map<String, String> mm = new LinkedHashMap<String, String>();
        mm.put("a", "aaa");
        mm.put("b", "bbb");
        mm.put("c", "ccc");
        context.put("mm", mm);
        BufferWriter bw = new BufferWriter();
        File f = File.createTempFile("test", "jssp");
        f.deleteOnExit();
        FileWriter fw = new FileWriter(f);
        fw.write("hello world\n" //
                 + "==============\n"//
                 + "<%var a =[1,3,5,7,9];a.each(function(o,i){%><%=i%> : <%=o%>\n<%});%>"//
                 + "==============\n"//
                 + "<%var a =[1,3,5,7,9];a.forEach(function(o,i){%><%=i%> : <%=o%>\n<%});%>"//
                 + "==============\n"//
                 + "<%$EACH(ac.get('aa'), function(o,i){%><%=i%> : <%=o%>\n<%});%>"//
                 + "==============\n"//
                 + "<%$EACH(ac.get('aa'), function(o){%>: <%=o%>\n<%});%>"//
                 + "==============\n"//
                 + "<%$MAP_EACH(ac.get('mm'), function(k,v){%><%=k%>: <%=v%>\n<%})%>" //
                 + "==============\n"//
        );
        fw.flush();
        fw.close();

        JsspExecutor.executeJssp(new FileResource(f), context, null, null, bw);

        System.out.println(bw.getBufferedString());
    }
}
