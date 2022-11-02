package com.fibanez.features.stream;

import java.util.OptionalInt;

public class OptionalIntClass {

    public static void main(String[] args) {
        // Create an empty OptionalInt
        OptionalInt empty = OptionalInt.empty();
        // Use an OptionalInt to store 287
        OptionalInt number = OptionalInt.of(287);

        if (number.isPresent()) {
            int value = number.getAsInt();
            System.out.println("Number is " + value);
        } else {
            System.out.println("Number is absent.");
        }
    }

}
