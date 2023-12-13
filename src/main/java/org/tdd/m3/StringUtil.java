package org.tdd.m3;

public class StringUtil {

    // TODO - Exercise
    public static String truncateWithEllipsis(String input, int limit, String cutOffChars){    if (input == null) {
        throw new IllegalArgumentException("String input must not be null");
    }

        if (limit < 1) {
            throw new IllegalArgumentException("Limit input must be greater than 0");
        }

        String ellipsis = "...";
        if (inputTooShort(input, limit, ellipsis)) {
            return input;
        }

        return input.substring(0, limit) + ellipsis;
    }


    public static String truncateWithEllipsis(String input, int limit) {
        return truncateWithEllipsis(input,limit,"...");
    }

    private static boolean inputTooShort(String input, int limit, String ellipsis) {
        return input.length() <= limit || input.length() <= ellipsis.length();
    }
}
