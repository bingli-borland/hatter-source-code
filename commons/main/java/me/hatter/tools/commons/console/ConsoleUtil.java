package me.hatter.tools.commons.console;

public class ConsoleUtil {

    public static String readLine(String prompt) {
        String line;
        do {
            System.out.print(prompt);
            line = System.console().readLine();
        } while (line.trim().length() == 0);
        return line;
    }
}