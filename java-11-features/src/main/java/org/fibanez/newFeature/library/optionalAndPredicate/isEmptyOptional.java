package org.fibanez.newFeature.library.optionalAndPredicate;

import java.util.Optional;

/**
 * Instead of using the negation of the isPresent() method, you can now just use the isEmpty() method to make the code easier to understand.
 */
public class isEmptyOptional {

    public static void main(String[] args) {
        Optional<String> payDay = Optional.ofNullable(null);
        System.out.println("Null check");
        System.out.println("isPresent: " + !payDay.isPresent());
        System.out.println("isEmpty: " + !payDay.isEmpty());
        System.out.println("\n");

        payDay = Optional.ofNullable("Monday");
        System.out.println("No null check");
        System.out.println("isPresent: " + !payDay.isPresent());
        System.out.println("isEmpty: " + !payDay.isEmpty());

        System.exit(0);
    }

}
