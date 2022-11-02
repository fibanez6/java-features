package com.fibanez.features.stream;

import java.util.stream.IntStream;

/**
 * Mapping a stream to another stream is not limited to any specific type of elements. You can map a stream of T to a
 * stream of type S, where T and S may be the same or different types. For example, you can map a stream of Person to
 * a stream of int where each Person element in the input stream maps to the Person’s ID in the mapped stream. You can
 * apply the map operation on a stream using one of the following methods of the Stream<T> interface:
 *
 * <R> Stream<R> map(Function<? super T,? extends R> mapper)
 * DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
 * IntStream mapToInt(ToIntFunction<? super T> mapper)
 * LongStream mapToLong(ToLongFunction<? super T> mapper)
 * <p>
 * The IntStream, LongStream, and DoubleStream interfaces contain similar methods to facilitate mapping of one type of
 * stream to another. The methods supporting the map operation on an IntStream are as follows:
 * <p>
 * IntStream map(IntUnaryOperator mapper)
 * DoubleStream mapToDouble(IntToDoubleFunction mapper)
 * LongStream mapToLong(IntToLongFunction mapper)
 * <U> Stream<U> mapToObj(IntFunction<? extends U> mapper)
 */
public class StreamsMap {

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
