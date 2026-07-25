package git.david;

import java.util.Objects;

public class Utility {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";

    public static void printColoredText(String text, String color) {
        if (Objects.equals(color, "red")) {
            System.out.println(RED + text + RESET);
        } else if (Objects.equals(color, "green")) {
            System.out.println(GREEN + text + RESET);
        } else if (Objects.equals(color, "yellow")) {
            System.out.println(YELLOW + text + RESET);
        }

    }

}
