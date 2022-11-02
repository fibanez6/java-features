package com.fibanez.features.stream;

import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.Map.entry;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * You can adapt the result of the collector to a different type; you can filter the elements after they are grouped but
 * before they are collected; you map elements as they are grouped, but before they are collected. The following static
 * methods in the Collectors class return such collectors:
 * <p>
 * <T,A,R,RR> Collector<T,A,RR> collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)
 * <T,A,R> Collector<T,?,R> filtering(Predicate<? super T> predicate, Collector<? super T,A,R> downstream)
 * <T,U,A,R> Collector<T,?,R> flatMapping(Function<? super T,? extends Stream<? extends U» mapper, Collector<? super U,A,R> downstream)
 * <p>
 * The filtering() and flatMapping() methods were added to the Collectors class in Java 9.
 * <p>
 * The filtering() method lets you group the elements, apply a filter in each group, and collect the filtered elements.
 * <p>
 * The flatMapping() method lets you apply a flat mapping function on each element.
 */
public class StreamsAdaptingCollector {

    public static void main(String[] args) {

        // returns an unmodifiable list of person names
        List<String> names = Person.persons()
                .stream()
                .map(Person::getName)
                .collect(collectingAndThen(
                        toList(),
                        result -> Collections.unmodifiableList(result)));
        System.out.println(names);

        // Adapting the Collector Result
        // to print the month’s name anyway and just add “None.”
        Map<Month, String> dobCalendar = Person.persons()
                .stream().collect(
                        collectingAndThen(
                                groupingBy(p ->
                                                p.getDob().getMonth(),
                                        mapping(Person::getName, joining(", "))),
                                result -> {
                                    // Add missing months
                                    for (Month m : Month.values()) {
                                        result.putIfAbsent(m, "None");
                                    }
                                    // Return a sorted, unmodifiable map
                                    return Collections.unmodifiableMap(new TreeMap<>(result));
                                }));
        dobCalendar.entrySet().forEach(System.out::println);

        // The filtering() method lets you group the elements, apply a filter in each group, and collect the filtered elements.
        // to group people by gender and collect only those people who make more than 8000.00
        Map<Person.Gender, List<Person>> makingOver8000 =
                Person.persons()
                        .stream()
                        .collect(groupingBy(
                                Person::getGender,
                                filtering(p -> p.getIncome() > 8000.00, toList())));
        System.out.println(makingOver8000);

        // Represent the gender and the list of spoken
        // languages
        List<Map.Entry<String, Set<String>>> list = List.of(
                entry("Male", Set.of("English", "French")),
                entry("Male", Set.of("Spanish", "Wu")),
                entry("Female", Set.of("English", "French")),
                entry("Male", Set.of("Wu", "Lao")),
                entry("Female", Set.of("English", "German")),
                entry("Male", Set.of("English")));
        Map<String, Set<String>> langByGender =
                list.stream()
                        .collect(groupingBy(Map.Entry::getKey,
                                flatMapping(e -> e.getValue().stream(), toSet())));
        System.out.println(langByGender);
    }
}
