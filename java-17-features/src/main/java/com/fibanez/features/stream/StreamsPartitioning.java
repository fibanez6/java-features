package com.fibanez.features.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Partitioning data is a special case of grouping data. Grouping data is based on the keys returned from a function.
 * There are as many groups as the number of distinct keys returned from the function. Partitioning collects data into
 * two groups: for one group, a condition is true; for the other, the same condition is false. The partitioning condition
 * is specified using a Predicate. By now, you might have guessed the name of the method in the Collectors class that
 * returns a collector to perform the partitioning. The method is partitioningBy() . It is overloaded and it has two versions:
 *
 * partitioningBy(Predicate<? super T> predicate)
 * partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
 */
public class StreamsPartitioning {

    public static void main(String[] args) {

        // If the predicate evaluates to true for an element, the element is added to the list for the key with a true value;
        // otherwise, the value is added to the list of values for the key with a false value.
        Map<Boolean, List<Person>> partitionedByMaleGender =
                Person.persons()
                        .stream()
                        .collect(Collectors.partitioningBy(Person::isMale));
        System.out.println(partitionedByMaleGender);

        // partitions people into male and non-male and collects their names in a comma-separated string
        Map<Boolean,String> partionedByMaleGender =
                Person.persons()
                        .stream()
                        .collect(Collectors.partitioningBy(
                                Person::isMale,
                                Collectors.mapping(Person::getName, Collectors.joining(", "))));
        System.out.println(partionedByMaleGender);
    }
}
