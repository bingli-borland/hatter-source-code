package me.hatter.tools.markdowndocs.template;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import me.hatter.tools.commons.file.FileUtil;
import me.hatter.tools.commons.io.IOUtil;
import me.hatter.tools.commons.string.StringUtil;
import me.hatter.tools.markdowndocs.config.GlobalVars;
import me.hatter.tools.markdowndocs.model.Page;
import me.hatter.tools.markdowndocs.model.Section;
import me.hatter.tools.markdowndocs.model.SubSection;

public class PageParser {

    // public static void main(String[] args) {
    // System.out.println(JSON.toJSONString(parsePage(new File(
    // "/Users/hatterjiang/Code/hatter-source-code/markdowndocs/samplex/01-Top10"))));
    // }

    public static Page parsePage(String dirName) {
        if (StringUtil.isEmpty(dirName)) {
            return parsePage(null, GlobalVars.getBasePath());
        } else {
            return parsePage(dirName, new File(GlobalVars.getBasePath(), dirName));
        }
    }

    public static Page parsePage(String dirName, File dir) {
        if ((dir == null) || (!dir.exists())) {
            return null;
        }

        Page page = new Page();
        page.setPath(((StringUtil.isEmpty(dirName)) ? "/" : "/" + dirName + "/"));
        page.setSummary(Markdown4jParser.parseMarkdown(new File(dir, "summary.md")));
        page.setNotice(Markdown4jParser.parseMarkdown(new File(dir, "notice.md")));
        page.setIndex(Markdown4jParser.parseMarkdown(new File(dir, "index.md")));
        page.setFooter(Markdown4jParser.parseMarkdown(new File(dir, "footer.md")));
        if (StringUtil.isNotEmpty(dirName) && (page.getFooter() == null)) {
            page.setFooter(Markdown4jParser.parseMarkdown(new File(GlobalVars.getBasePath(), "footer.md")));
        }

        File[] mds;
        mds = dir.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                if (!name.endsWith(".md")) {
                    return false;
                }

                if (Arrays.asList("summary.md", "notice.md", "index.md", "footer.md").contains(name)) {
                    return false;
                }

                return true;
            }
        });
        if ((mds != null) && (mds.length > 0)) {
            Arrays.sort(mds, new Comparator<File>() {

                public int compare(File f1, File f2) {
                    String n1 = f1.getName().substring(0, f1.getName().length() - 3);
                    String n2 = f2.getName().substring(0, f2.getName().length() - 3);
                    if (n1.startsWith(n2)) {
                        return 1;
                    }
                    if (n2.startsWith(n1)) {
                        return -1;
                    }
                    return n1.compareTo(n2);
                }
            });

            // for (File f : mds) {
            // System.out.println(f);
            // }

            Map<File, List<File>> mdMap = new LinkedHashMap<File, List<File>>();
            File lastSMd = null;
            for (File md : mds) {
                if (lastSMd == null) {
                    // first section
                    lastSMd = md;
                    mdMap.put(lastSMd, new ArrayList<File>());
                } else {
                    if (md.getName().startsWith(lastSMd.getName().substring(0, lastSMd.getName().length() - 3))) {
                        // subsection
                        mdMap.get(lastSMd).add(md);
                    } else {
                        // new section
                        lastSMd = md;
                        mdMap.put(lastSMd, new ArrayList<File>());
                    }
                }
            }

            page.setSections(new ArrayList<Section>());
            for (Entry<File, List<File>> mdEntry : mdMap.entrySet()) {
                Section section = new Section();
                File md = mdEntry.getKey();
                SubSection _secSection = parseSubSection(md);
                section.setId(_secSection.getId());
                section.setName(_secSection.getName());
                section.setTitle(_secSection.getTitle());
                section.setContent(_secSection.getContent());

                if ((mdEntry.getValue() != null) && (!mdEntry.getValue().isEmpty())) {
                    section.setSubSections(new ArrayList<SubSection>());
                    for (File smd : mdEntry.getValue()) {
                        section.getSubSections().add(parseSubSection(smd));
                    }
                }
                page.getSections().add(section);
            }
        }

        return page;
    }

    public static SubSection parseSubSection(File md) {
        SubSection subSection = new SubSection();
        subSection.setId(md.getName().substring(0, md.getName().length() - 3));
        List<String> lines = new ArrayList<String>(IOUtil.readToList(FileUtil.readFileToString(md)));
        if (lines.size() > 0) {
            String firstLine = lines.remove(0);
            String name = firstLine;
            String title = firstLine;
            if (firstLine.contains(":::")) {
                name = StringUtil.substringBefore(firstLine, ":::");
                title = StringUtil.substringAfter(firstLine, ":::");
            }
            subSection.setName(name);
            subSection.setTitle(title);
            // subSection.setName(Markdown4jParser.parseMarkdown(name));
            // subSection.setTitle(Markdown4jParser.parseMarkdown(title));
        }
        subSection.setContent(Markdown4jParser.parseMarkdown(StringUtil.join(lines, "\n")));
        return subSection;
    }
}
