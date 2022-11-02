package com.fibanez.features.thread.scheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * What happens when an uncaught exception occurs during a task execution? The executor framework handles occurrences of
 * such uncaught exception nicely for you.
 */
public class BadRunnableTask {
    public static void main(String[] args) {
        Runnable badTask = () -> {
            throw new RuntimeException("The task threw an exception...");
        };
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(badTask);
        exec.shutdown();
    }
}
