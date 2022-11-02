package org.fibanez.newFeature.library.string;

/**
 * Takes care of removing leading and trailing whitespaces.
 */
public class RemovingLeadingTrailingWhitespacesString {

    public static void main(String[] args) {
        String nameFormField = "      Java Duke     ";

        System.out.println(nameFormField.strip());
        System.out.println(nameFormField.stripLeading());
        System.out.println(nameFormField.stripTrailing());
        System.exit(0);
    }
}
