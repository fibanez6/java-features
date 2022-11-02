package org.fibanez.newFeature.library.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Process multiline texts as a Stream.
 * A Stream represents a sequence of elements that can be processed sequentially without having to
 * load all of the elements into memory at once.
 */
public class ProcessingMultilineString {

    public static void main(String[] args) {
        String testString = "This\nis\na\ntest";
        List<String> lines = new ArrayList<>();

        testString.lines().forEach(System.out::println);
        System.exit(0);
    }
}
