package com.fibanez.features.stream;

import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.summarizingDouble;

/**
 * Grouping data for reporting purposes is common. For example, you may want to know the average income by gender,
 * the youngest person by gender, etc. In previous sections, you used the toMap() method of the Collectors class
 * to get collectors that can be used to group data in maps. The groupingBy() method of the Collectors class returns
 * a collector that groups the data before collecting them in a Map. If you have worked with SQL statements, it is
 * similar to using a “group by” clause. The groupingBy() method is overloaded, and it has three versions:
 * <p>
 * groupingBy(Function<? super T,? extends K> classifier)
 * groupingBy(Function<? super T,? extends K> classifier, super T,A,D> downstream)
 * groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
 * <p>
 * mapping() method
 * <p>
 * It is another Collector. This is where dealing with grouping data gets complex. You need to nest collectors inside
 * collectors. To simplify the grouping process, you break down the things you want to perform on the data. You have
 * already grouped people by their gender. The value of each key in the map was a List<Person>. Now you want to reduce
 * the List<Person> to a String that contains a comma-separated list of the names of all the people. You need to think
 * about this operation separately to avoid confusion. You can accomplish this reduction as follows:
 * <p>
 * 1. Use a function to map each person to their name. This function could be as simple as a method reference like
 * Person::getName. Think of the output of this step as a stream of person names in a group.
 * <p>
 * 2. What do you want to do with the stream of names generated in the first step? You may want to collect them in a
 * String, a List, a Set, or some other data structure. In this case, you want to join the names of people, so you
 * use the collector returned from the joining() method of the Collectors class.
 */
public class StreamsGrouping {

    public static void main(String[] args) {

        // groupingBy() method
        // collects the list of people by gender
        Map<Person.Gender, List<Person>> personsByGender =
                Person.persons()
                        .stream()
                        .collect(Collectors.groupingBy(Person::getGender));
        System.out.println(personsByGender);

        // group people by gender and count the number of people in each group.
        Map<Person.Gender, Long> countByGender =
                Person.persons()
                        .stream()
                        .collect(Collectors.groupingBy(
                                Person::getGender,
                                Collectors.counting()));
        System.out.println(countByGender);

        // mapping() method
        // group the names of people by gender
        // The code collects the names for a group in a comma-separated String
        Map<Person.Gender, String> namesByGender01 =
                Person.persons()
                        .stream()
                        .collect(Collectors.groupingBy(Person::getGender,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.joining(", "))));
        System.out.println(namesByGender01);

        // the collector returned by the toList() method of the Collectors class
        Map<Person.Gender, List<String>> namesByGender02 =
                Person.persons()
                        .stream()
                        .collect(Collectors.groupingBy(Person::getGender,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toList())));
        System.out.println(namesByGender02);

        // Using Nested Groupings
        Map<Person.Gender, Map<Month, String>>
                personsByGenderAndDobMonth
                = Person.persons()
                .stream()
                .collect(
                        groupingBy(Person::getGender,
                                groupingBy(p -> p.getDob().getMonth(),
                                        mapping(Person::getName, joining(", ")))));
        System.out.println(personsByGenderAndDobMonth);

        // Summary Statistics of Income Grouped by Gender
        Map<Person.Gender, DoubleSummaryStatistics> incomeStatsByGender =
                Person.persons()
                        .stream()
                        .collect(
                                groupingBy(Person::getGender,
                                        summarizingDouble(Person::getIncome)));
        System.out.println(incomeStatsByGender);
    }
}
