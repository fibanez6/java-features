package com.fibanez.features.lambda.funtionalInterface;

import java.util.List;

import static com.fibanez.features.lambda.funtionalInterface.Gender.MALE;

public class FunctionUtilTest {
    public static void main(String[] args) {
        List<Person> list = Person.getPersons();
        // Use the forEach() method to print each person
        // in the list
        System.out.println("Original list of persons:");
        FunctionUtil.forEach(list, p ->
                System.out.println(p));
        // Filter only males
        List<Person> maleList = FunctionUtil.filter(list,
                p -> p.getGender() == MALE);
        System.out.println("\nMales only:");
        FunctionUtil.forEach(maleList,
                p -> System.out.println(p));
        // Map each person to his/her year of birth
        List<Integer> dobYearList = FunctionUtil.map(list,
                p -> p.getDob().getYear());
        System.out.println("\nPersons mapped to year of " +
                "their birth:");
        FunctionUtil.forEach(dobYearList,
                year -> System.out.println(year));
        // Apply an action to each person in the list.
        // Add one year to each male's dob
        FunctionUtil.forEach(maleList,
                p -> p.setDob(p.getDob().plusYears(1)));
        System.out.println("\nMales only after adding " +
                "1 year to DOB:");
        FunctionUtil.forEach(maleList,
                p -> System.out.println(p));
    }
}
