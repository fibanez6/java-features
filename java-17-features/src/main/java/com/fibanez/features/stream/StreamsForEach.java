package com.fibanez.features.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * The forEach operation takes an action for each element of the stream. The action may simply print each element of the
 * stream to the standard output or increase the income of every person in a stream by 10%. The Stream<T> interface
 * contains two methods to perform the forEach operation:
 *
 * void forEach(Consumer<? super T> action)
 * void forEachOrdered(Consumer<? super T> action)
 */
public class StreamsForEach {

    public static void main(String[] args) {

        // prints the details of females in the person list
        Person.persons()
                .stream()
                .filter(Person::isFemale)
                .forEach(System.out::println);

        // Applying the ForEach Operation on a List of Persons
        // Get the list of persons
        List<Person> persons = Person.persons();
        // Print the list
        System.out.println("Before increasing the income: " + persons);
        // Increase the income of females by 10%
        persons.stream()
                .filter(Person::isFemale)
                .forEach(p -> p.setIncome(p.getIncome() * 1.10));

        // Print the list again
        System.out.println("After increasing the income: " + persons);
    }
}
