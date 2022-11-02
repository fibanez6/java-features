package com.fibanez.features.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The joining() method of the Collectors class returns a collector that concatenates the elements of a stream of
 * CharSequence and returns the result as a String. The concatenation occurs in the encounter order. The joining()
 * method is overloaded, and it has three versions:
 * <p>
 * joining()
 * joining(CharSequence delimiter)
 * joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
 */
public class StreamsCollectJoining {

    public static void main(String[] args) {

        List<Person> persons = Person.persons();
        String names = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining());

        String delimitedNames = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        String prefixedNames = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Hello ", ". Goodbye."));

        System.out.println("Joined names: " + names);
        System.out.println("Joined, delimited names: " + delimitedNames);
        System.out.println(prefixedNames);

    }
}
