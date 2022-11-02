package org.fibanez.newFeature.library.string;

/**
 * Indicates whether a string is empty or contains only whitespaces.
 */
public class IsBlankString {

    public static void main(String[] args) {
        String nameFormFieldWithoutWhitespace = "Duke";
        String nameFormFieldWithWhitespace = " ";

        System.out.println(nameFormFieldWithoutWhitespace.isBlank());
        System.out.println(nameFormFieldWithWhitespace.isBlank());
        System.exit(0);
    }
}
