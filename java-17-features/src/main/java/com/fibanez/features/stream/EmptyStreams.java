package com.fibanez.features.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * An empty stream is a stream with no elements.
 * The Stream interface contains an empty() static method to create an empty sequential stream
 */
public class EmptyStreams {

    public static void main(String[] args) {

        // Creates an empty stream of strings
        Stream<String> stream = Stream.empty();

        // Creates an empty stream of integers
        IntStream numbers = IntStream.empty();
    }
}
