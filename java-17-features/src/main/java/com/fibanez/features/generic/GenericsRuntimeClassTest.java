package com.fibanez.features.generic;

public class GenericsRuntimeClassTest {
    public static void main(String[] args) {
        Wrapper<String> a =
                new Wrapper<String>("Hello");
        Wrapper<Integer> b =
                new Wrapper<Integer>(Integer.valueOf(123));
        Class aClass = a.getClass();
        Class bClass = b.getClass();
        System.out.println("Class for a: " +
                aClass.getName());
        System.out.println("Class for b: " +
                bClass.getName());
        System.out.println("aClass == bClass: " +
                (aClass == bClass));
    }
}
