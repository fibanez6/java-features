package com.fibanez.features.lambda.funtionalInterface;

@FunctionalInterface
public interface Processor {
    <T> void process(T[] list);
}
