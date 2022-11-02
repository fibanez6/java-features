package com.fibanez.features.stream;

import java.util.stream.Stream;

/**
 * You apply a sequence of operations on a stream. Each operation transforms the elements of the input stream, either
 * producing another stream or a result. Sometimes, you may need to look at the elements of the streams as they pass
 * through the pipeline. You can do so by using the peek(Consumer<? super T> action) method of the Stream<T> interface
 * that is meant only for debugging purposes. It produces a stream after applying an action on each input element.
 */
public class StreamsDebugging {

    public static void main(String[] args) {

        int sum = Stream.of(1, 2, 3, 4, 5)
                .peek(e -> System.out.println("Taking integer: " + e))
                .filter(n -> n % 2 == 1)
                .peek(e -> System.out.println("Filtered integer: " + e))
                .map(n -> n * n)
                .peek(e -> System.out.println("Mapped integer: " + e))
                .reduce(0, Integer::sum);
    }
}
