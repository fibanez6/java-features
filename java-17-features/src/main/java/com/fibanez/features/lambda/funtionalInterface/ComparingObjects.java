package com.fibanez.features.lambda.funtionalInterface;

import java.util.List;

public class ComparingObjects {
    public static void main(String[] args) {
        List<Person> persons = Person.getPersons();
        // Sort using the first name
        persons.sort(java.util.Comparator.comparing(
                Person::getFirstName));
        // Print the sorted list
        System.out.println("Sorted by the first name:");
        FunctionUtil.forEach(persons, System.out::println);
        // Sort using the last name, first name, and then
        // DOB
        persons.sort(java.util.Comparator.comparing(
                        Person::getLastName)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getDob));
        // Print the sorted list
        System.out.println("\nSorted by the last name, " +
                "first name, and dob:");
        FunctionUtil.forEach(persons, System.out::println);
    }
}
