package com.fibanez.features.thread.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleExplicitLock {
    // Instantiate the lock object
    private final Lock myLock = new ReentrantLock();

    public void updateResource() {
        // Acquire the lock
        myLock.lock();
        try {
            // Logic for updating/reading the shared
            // resource goes here
        } finally {
            // Release the lock
            myLock.unlock();
        }
    }

    // the synchronized keyword to achieve the same effect
    public void updateResourceSync() {
        // Acquire the lock and the lock will be released
        // automatically by the JVM when your code exits the
        // block
        synchronized (this) {
            // Logic for updating/reading the shared
            // resource goes here
        }
    }

}