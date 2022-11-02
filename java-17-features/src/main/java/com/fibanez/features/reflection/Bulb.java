package com.fibanez.features.reflection;

public class Bulb {
    static {
        // This will execute when this class is loaded
        // and initialized
        System.out.println("Loading class Bulb...");
    }
}
