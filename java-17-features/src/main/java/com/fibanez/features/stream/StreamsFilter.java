package com.fibanez.features.stream;

import java.util.stream.Stream;

/**
 * The filter operation is applied on an input stream to produce another stream, which is known as the filtered stream.
 * The filtered stream contains all elements of the input stream for which a predicate evaluates to true. A predicate
 * is a function that accepts an element of the stream and returns a boolean value. Unlike a mapped stream, the filtered
 * stream is of the same type as the input stream.
 *
 * The filter operation produces a subset of the input stream. If the predicate evaluates to false for all elements of
 * the input stream, the filtered stream is an empty stream
 */
public class StreamsFilter {

    public static void main(String[] args) {

        // only females.
        Person.persons()
                .stream()
                .filter(Person::isFemale)
                .map(Person::getName)
                .forEach(System.out::println);

        // two filter operations to print the names of all males having income more than 5000.0
        Person.persons()
                .stream()
                .filter(Person::isMale)
                .filter(p -> p.getIncome() > 5000.0)
                .map(Person::getName)
                .forEach(System.out::println);

        // You could have accomplished the same using the following statement that uses only one filter operation that
        // includes both predicates for filtering into one predicate:
        Person.persons()
                .stream()
                .filter(p -> p.isMale() && p.getIncome() > 5000.0)
                .map(Person::getName)
                .forEach(System.out::println);


        // If you use a predicate in the dropWhile() method that returns true for an integer less than 5, the method
        // will drop the first four elements and return the rest
        Stream.of(1, 2, 3, 4, 5, 6, 7)
                .dropWhile(e -> e < 5)
                .forEach(System.out::println);

        // returns the matching elements from the beginning of the stream and discards the rest.
        Stream.of(1, 2, 3, 4, 5, 6, 7)
                .takeWhile(e -> e < 5)
                .forEach(System.out::println);
    }
}
