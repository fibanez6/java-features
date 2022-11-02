package com.fibanez.features.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The Streams API also supports one-to-many mapping through the flatMap operation
 *
 * 1. It takes an input stream and produces an output stream using a mapping function.
 * <p>
 * 2. The mapping function takes an element from the input stream and maps the element to a stream. The type of input
 * element and the elements in the mapped stream may be different. This step produces a stream of streams. Suppose
 * the input stream is a Stream<T> and the mapped stream is Stream<Stream<R» where T and R may be the same or different.
 * <p>
 * 3. Finally, it flattens the output stream (i.e., a stream of streams) to produce a stream. That is, the Stream<Stream<R»
 * is flattened to Stream<R>.
 */
public class StreamsFlatMap {

    public static void main(String[] args) {

        Stream.of(1, 2, 3)
                .map(n -> Stream.of(n, n * n))
                .forEach(System.out::println);

        // Produces
//        java.util.stream.ReferencePipeline$Head@372f7a8d
//        java.util.stream.ReferencePipeline$Head@2f92e0f4
//        java.util.stream.ReferencePipeline\$Head@28a418fc

        long count01 = Stream.of("Ken", "Jeff", "Ellen")
                .map(name -> name.chars())
                .flatMap(intStream -> intStream.mapToObj(n -> (char) n))
                .filter(ch -> ch == 'e' || ch == 'E')
                .count();

        long count02 = Stream.of("Ken", "Jeff", "Ellen")
                .flatMap(name ->
                        IntStream.range(0, name.length())
                                .mapToObj(name::charAt))
                .filter(ch -> ch == 'e' || ch == 'E')
                .count();
    }
}
