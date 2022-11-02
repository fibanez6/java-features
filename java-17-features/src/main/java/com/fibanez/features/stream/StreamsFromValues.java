package com.fibanez.features.stream;

import java.util.stream.Stream;

/**
 * The Stream interface contains the following three static methods to create a sequential Stream from a single value and multiple values:
 *
 * <T> Stream<T> of(T t)
 * <T> Stream<T> of(T...values)
 * <T> Stream<T> ofNullable(T t)
 */
public class StreamsFromValues {

    public static void main(String[] args) {

        // Creates a stream with one string element
        Stream<String> stream01 = Stream.of("Hello");

        // Creates a stream with four string elements
        Stream<String> stream02 = Stream.of("Ken", "Jeff", "Chris", "Ellen");

        // The ofNullable() method returns a stream with a single value if the specified value is non-null.

        String str = "Hello";
        // Stream s1 will have one element "Hello"
        Stream<String> s1 = Stream.ofNullable(str);

        str = null;
        // Stream s2 is an empty stream because str is null
        Stream<String> s2 = Stream.ofNullable(str);


        // Creates a stream of four strings in the names array
        String[] names01 = {"Ken", "Jeff", "Chris", "Ellen"};
        Stream<String> stream03 = Stream.of(names01);

        // The stream will contain 4 elements:
        String names02 = "Ken,Jeff,Chris,Ellen";
        // "Ken", "Jeff", "Chris", and "Ellen"
        Stream<String> stream04 = Stream.of(names02.split(","));

        // Gets a stream builder
        Stream.Builder<String> builder = Stream.builder();
        // Add elements and build the stream
        Stream<String> stream = builder.add("Ken").add("Jeff").add("Chris").add("Ellen").build();

    }
}
