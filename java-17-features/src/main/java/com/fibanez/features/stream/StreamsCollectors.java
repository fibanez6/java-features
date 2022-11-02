package com.fibanez.features.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * you may want to apply complex logic to summarize the stream’s data. For example, you may want to group people by their
 * gender and compute the highest earner in every gender group. This is possible using the collect() method of the Stream<T>
 * interface. The collect() method is overloaded with two versions:
 *
 * <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
 * <R,A> R collect(Collector<? super T,A,R> collector): The method uses a mutable reduction operation. It uses a mutable container such as a mutable Collection to compute the results from the input stream. The first version of the collect() method takes three arguments:
 * - A supplier that supplies a mutable container to store (or collect) the results
 * - An accumulator that accumulates the results into the mutable container
 * - A combiner that combines the partial results when the reduction operation takes place in parallel
 */
public class StreamsCollectors {

    public static void main(String[] args) {

        // the collect() method to collect the names of all people in a list
        List<String> names01 = Person.persons()
                .stream()
                .map(Person::getName)
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
        System.out.println(names01);


        // Collectors that provides out-of-the-box implementations for commonly used collectors.
        List<String> names02 = Person.persons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(names02);

        // collects all names in a Set<String>
        // Note that a Set keeps only unique elements
        Set<String> uniqueNames = Person.persons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        System.out.println(uniqueNames);

        // Order - TreeSet is a sorted set, to collect the data.
        SortedSet<String> uniqueSortedNames = Person.persons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(uniqueSortedNames);

        // sort the list of names using the sorted operation
        List<String> sortedName = Person.persons()
                .stream()
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList());

        //  the counting() method that returns the number of input elements
        long count01 = Person.persons()
                .stream()
                .collect(Collectors.counting());
        System.out.println("Person count: " + count01);

        // you could have achieved the same result using the count() method of the Stream interface
        long count02 = Person.persons()
                .stream()
                .count();
        System.out.println("Persons count: " + count02);
    }
}
