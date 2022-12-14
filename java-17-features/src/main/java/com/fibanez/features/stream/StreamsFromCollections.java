package com.fibanez.features.stream;

import java.util.Set;
import java.util.stream.Stream;

/**
 * The Collection interface contains the stream() and parallelStream() methods that create sequential and parallel streams
 * from a Collection, respectively.
 */
public class StreamsFromCollections {

    public static void main(String[] args) {

        // Create and populate a set of strings
        Set<String> names = Set.of("Ken", "jeff");

        // Create a sequential stream from the set
        Stream<String> sequentialStream = names.stream();

        // Create a parallel stream from the set
        Stream<String> parallelStream = names.parallelStream();
    }
}
