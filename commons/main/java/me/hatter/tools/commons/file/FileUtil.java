package me.hatter.tools.commons.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import me.hatter.tools.commons.io.IOUtil;

public class FileUtil {

    public static final String SEPARATER = File.separator;

    public static void writeStringToFile(File file, String content) {
        writeStringToFile(file, content, IOUtil.CHARSET_UTF8);
    }

    public static void writeStringToFile(File file, String content, String charset) {
        try {
            IOUtil.writeStringAndClose(new FileOutputStream(file), content, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFileToString(File file) {
        return readFileToString(file, IOUtil.CHARSET_UTF8);
    }

    public static String readFileToString(File file, String charset) {
        try {
            return IOUtil.readToString(new FileInputStream(file), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeBytesToFile(File file, byte[] bytes) {
        try {
            IOUtil.writeBytesAndClose(new FileOutputStream(file), bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] readFileToBytes(File file) {
        try {
            return IOUtil.readToBytesAndClose(new FileInputStream(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void listFiles(File dir, FileFilter fileFilter, List<File> refFiles) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (fileFilter.accept(f)) {
                    if (refFiles != null) {
                        refFiles.add(f);
                    }
                    listFiles(f, fileFilter, refFiles);
                }
            }
        }
    }
}