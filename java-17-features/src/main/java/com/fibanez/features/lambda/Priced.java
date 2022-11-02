package com.fibanez.features.lambda;

public interface Priced {
    default double getPrice() {
        return 1.0;
    }
}
