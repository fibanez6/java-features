package org.fibanez.newFeature.library.optionalAndPredicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;

/**
 * Starting with Java 10, you can declare local variables without having to assign the type. Instead of declaring the
 * type, the variable uses the var keyword. At runtime, the assignment for the variable automatically determines the
 * type; it is inferred. Even when using the var keyword, the variable is still statically typed.
 *
 * With Java 11, you can now also use the var keyword for parameters of a Lambda. Using var for Lambda parameters comes
 * with a major benefit: you can annotate the variable. For example, you could indicate that the value of the variable
 * cannot be null by using JSR-303’s @NotNull annotation.
 *
 * Let’s go back to the Predicate.not(Predicate) method used in an earlier example. In the following example, we
 * enhanced the Lambda definition by providing the var keyword plus an annotation:
 */
public class varKeywordLambda {

    public static void main(String[] args) {
        List<String> months = List.of("January", "February", "March");
        List<String> filteredMonths = months
                .stream()
                .filter(Predicate.not((@NotNull var month) -> month.startsWith("M")))
                .collect(Collectors.toList());

        System.out.println("filtered: " + filteredMonths);
        System.exit(0);
    }
}
