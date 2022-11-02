package org.fibanez.newFeature.library.optionalAndPredicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Suppose that you want to filter a stream of strings, such as certain months. The new Predicate method can be
 * enormously helpful with filtering all months that do not fulfill a certain condition. In the code that follows,
 * you’ll find an example that filters out all months that do not begin with the letter “M.” That’s far more expressive
 * than having to pass (Predicate<String>) month -> month.startsWith("M")).negate() to the filter method.
 */
public class NotPredicate {

    public static void main(String[] args) {
        List<String> months = List.of("January", "February", "March");
        List<String> filteredMonths = months
                .stream()
                .filter(Predicate.not(month -> month.startsWith("M")))
                .collect(Collectors.toList());

        System.out.println("filtered: " + filteredMonths);
        System.exit(0);
    }

}
