package com.fibanez.features.stream;

import java.util.stream.Collectors;

/**
 * Streams can be sequential or parallel. Operations on a sequential stream are processed in serial using one thread.
 * Operations on a parallel stream are processed in parallel using multiple threads. You do not need to take additional
 * steps to process streams because they are sequential or parallel. All you need to do is call the appropriate method
 * that produces a sequential or parallel stream. Everything else is taken care of by the Streams API.
 */
public class StreamsParallel {

    public static void main(String[] args) {

        // serial processing of the stream pipeline because the stream is sequential
        String names01 = Person
                .persons()              // The data source
                .stream()               // Produces a sequential stream
                .filter(Person::isMale) // Processed in serial
                .map(Person::getName)   // Processed in serial
                .collect(Collectors.
                        joining(", "));     // Processed in serial


        // parallel processing of the stream pipeline because the stream is parallel
        String names02 = Person
                .persons()              // The data source
                .parallelStream()       // Produces a parallel stream
                .filter(Person::isMale) // Processed in parallel
                .map(Person::getName)   // Processed in parallel
                .collect(Collectors.
                        joining(", "));     // Processed in parallel

        // processing of the stream pipeline in mixed mode because the operations in the pipeline produce serial and parallel streams
        String names03 = Person
                .persons()              // The data source
                .stream()               // Produces a sequential stream
                .filter(Person::isMale) // Processed in serial
                .parallel()             // Produces a parallel stream
                .map(Person::getName)   // Processed in parallel
                .collect(Collectors.
                        joining(", "));     // Processed in parallel
    }
}
