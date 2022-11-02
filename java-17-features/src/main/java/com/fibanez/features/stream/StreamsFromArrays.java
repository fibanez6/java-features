package com.fibanez.features.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The Arrays class in the java.util package contains an overloaded stream() static method to create sequential streams
 * from arrays. You can use it to create an IntStream from an int array, a LongStream from a long array, a DoubleStream
 * from a double array, and a Stream<T> from an array of the reference type T.
 */
public class StreamsFromArrays {

    public static void main(String[] args) {

        // Creates a stream from an int array with elements
        // 1, 2, and 3
        IntStream numbers = Arrays.stream(new int[]{1, 2, 3});

        // Creates a stream from a String array with elements
        // "Ken", and "Jeff"
        Stream<String> names = Arrays.stream(new String[]{"Ken", "Jeff"});

    }
}
