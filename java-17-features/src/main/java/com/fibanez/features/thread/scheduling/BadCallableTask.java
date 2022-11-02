package com.fibanez.features.thread.scheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

/**
 * If you are submitting a task  using the submit() method of  the ExecutorService,  the executor framework handles  the
 * exception and indicates that to you when you use the get() method to get the result of the task execution.  The get()
 * method of the Future instance throws an ExecutionException,  wrapping the actual exception as its cause.  You can use
 * the get() method of the Future instance even if you submit a Runnable task. On successful execution of the task,  the
 * get() method will return null. If an uncaught exception is thrown during the task execution, it throws an
 */
public class BadCallableTask {
    public static void main(String[] args) {
        Callable<Object> badTask = () -> {
            throw new RuntimeException("The task threw an exception...");
        };

        // Create an executor service
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // Submit a task
        Future submittedTask = exec.submit(badTask);
        try {
            // The get method should throw
            // ExecutionException
            Object result = submittedTask.get();
        } catch (ExecutionException e) {
            System.out.println("Execution exception has occurred: " + e.getMessage());
            System.out.println("Execution exception cause is: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }
}