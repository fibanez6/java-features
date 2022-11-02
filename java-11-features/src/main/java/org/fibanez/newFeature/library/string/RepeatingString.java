package org.fibanez.newFeature.library.string;

/**
 * It simply repeats a string n times.
 */
public class RepeatingString {

    /**
     * Imagine that you need to build a data table with padded whitespaces or dots between key/value pairs to improve its readability.
     */
    public static void main(String[] args) {
        System.out.println(renderInfo("Memory Usage:", "9.14 MB", " "));
        System.out.println(renderInfo("CPU Usage:", "5%", " "));
        System.out.println(renderInfo("Free Disk:", "96.5 GB", " "));
        System.out.println("\n");
        System.out.println(renderInfo("Memory Usage:", "9.14 MB", "."));
        System.out.println(renderInfo("CPU Usage:", "5%", "."));
        System.out.println(renderInfo("Free Disk:", "96.5 GB", "."));
        System.exit(0);
    }

    private static String renderInfo(String title, String value, String delimiter) {
        return title + delimiter.repeat(30 - title.length() - value.length()) + value;
    }
}
