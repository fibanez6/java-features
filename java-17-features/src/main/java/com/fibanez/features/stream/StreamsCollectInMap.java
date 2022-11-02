package com.fibanez.features.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * You can collect data from a stream into a Map. The toMap() method of the Collectors class returns a collector to
 * collect data in a Map. The method is overloaded and it has three versions:
 *
 * toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
 * toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
 * toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier)
 */
public class StreamsCollectInMap {

    public static void main(String[] args) {

        // Collects a person’s data in a Map<long,String> whose keys are the person’s IDs and values are the person’s names
        Map<Long,String> idToNameMap = Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(idToNameMap);

        // about the duplicate keys
        // you specify a merge function as a third argument. The merge function is passed the old and new values for the duplicate key.
        Map<Person.Gender,String> genderToNamesMap =
                Person.persons()
                        .stream()
                        .collect(Collectors.toMap(
                                Person::getGender,
                                Person::getName,
                                (oldValue, newValue) -> String.join(", ", oldValue, newValue)));
        System.out.println(genderToNamesMap);

        // Collecting the Highest Earner by Gender in a Map
        Map<Person.Gender, Person> highestEarnerByGender =
                Person.persons()
                        .stream()
                        .collect(Collectors.toMap(
                                Person::getGender,
                                Function.identity(),
                                (oldPerson, newPerson) -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
        System.out.println(highestEarnerByGender);
    }
}
