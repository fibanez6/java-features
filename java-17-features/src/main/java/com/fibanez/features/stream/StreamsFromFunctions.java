package com.fibanez.features.stream;

import java.util.stream.Stream;

/**
 * An infinite stream is a stream with a data source capable of generating an infinite number of elements. Note that I
 * am saying that the data source should be “capable of generating” an infinite number of elements, not that the data
 * source should have or contain an infinite number of elements. It is impossible to store an infinite number of elements
 * of any kind because of memory and time constraints. However, it is possible to have a function that can generate an
 * infinite number of values on demand. The Stream interface contains the following two static methods to generate an
 * infinite stream:
 *
 * <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, Unary-Operator<T> next)
 * <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
 * <T> Stream<T> generate(Supplier<? extends T> s)
 *
 * The iterate() method creates a sequential ordered stream, whereas the generate() method creates a sequential unordered
 * stream. The following sections show you how to use these methods.
 *
 * The generate(Supplier<? extends T> s) method uses the specified Supplier to generate an infinite sequential unordered stream.
 */
public class StreamsFromFunctions {

    public static void main(String[] args) {

        // The following snippet of code creates an infinite stream of prime numbers and prints the first five prime numbers on the standard output
        Stream.iterate(2L, PrimeUtil::next)
                .limit(5)
                .forEach(System.out::println);

        // Print the first 5 prime numbers
        Stream.iterate(2L, n -> n + 1)
                .filter(PrimeUtil::isPrime)
                .limit(5)
                .forEach(System.out::println);


        // Discard some elements of a stream
        Stream.iterate(2L, PrimeUtil::next)
                .skip(100)
                .limit(5)
                .forEach(System.out::println);


        // Uses the specified Supplier to generate an infinite sequential unordered stream
        Stream.generate(new PrimeUtil()::next)
                .skip(100)
                .limit(5)
                .forEach(System.out::println);
    }
}
