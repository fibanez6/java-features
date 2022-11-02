package com.fibanez.features.stream;

import java.util.Optional;

/**
 * An Optional is a container object that may or may not contain a non-null value.
 *
 * How do you create an Optional<T> object? The Optional<T> class provides the following static factory methods to create its objects:
 *
 * <T> Optional<T> empty(): Returns an empty Optional. That is, the Optional returned from this method does not contain a non-null value.
 * <T> Optional<T> of(T value): Returns an Optional containing the specified value as the non-null value. If the specified value is null, it throws a NullPointerException.
 * <T> Optional<T> ofNullable(T value): Returns an Optional containing the specified value if the value is non-null. If the specified value is null, it returns an empty Optional.
 */
public class OptionalClass {

    // Create an empty Optional
    Optional<String> empty = Optional.empty();
    // Create an Optional for the string "Hello"
    Optional<String> str = Optional.of("Hello");
    // Create an Optional with a String that may be null
    String nullableString = "";
    // <- get a string that may be null...
    Optional<String> str2 = Optional.of(nullableString);


}
