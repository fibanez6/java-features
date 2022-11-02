package com.fibanez.features.thread.threadLocal;

import java.util.Random;
import java.util.stream.IntStream;

public class ThreadLocalInternalStream {

    public static void main(String[] args) throws InterruptedException {
        // Let's start three threads to the
        // CallTracker.call() method

        Thread t1 = new Thread(ThreadLocalInternalStream::run);
        Thread t2 = new Thread(ThreadLocalInternalStream::runParallel);
        t1.start();
        t1.join();
        System.out.println("\n -------------- \n -------------- \n -------------- \n");
        t2.start();
    }

    public static void run() {
        int counter = 5;
        IntStream.range(0,5).forEach( n -> {
            // Print the thread name and the generated random
            // number by the thread
            System.out.println(Thread.currentThread().getName() + " generated counter: " + counter);
            for (int i = 0; i < counter; i++) {
                CallTracker.call();
            }
        });

        Integer counterObject = CallTracker.getThreadLocal().get();
        System.out.println("\n -------------- \n");
        System.out.println(Thread.currentThread().getName() + " Final value: " + counterObject);
    }

    public static void runParallel() {
        int counter = 5;
        IntStream.range(0,3).parallel().forEach( n -> {
            // Print the thread name and the generated random
            // number by the thread
            System.out.println(Thread.currentThread().getName() + " generated counter: " + counter);
            for (int i = 0; i < counter; i++) {
                CallTracker.call();
            }
        });

        Integer counterObject = CallTracker.getThreadLocal().get();
        System.out.println("\n -------------- \n");
        System.out.println(Thread.currentThread().getName() + " Final value: " + counterObject);
    }
}
