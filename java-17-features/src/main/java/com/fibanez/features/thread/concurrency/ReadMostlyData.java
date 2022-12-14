package com.fibanez.features.thread.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * The ReadWriteLock  allows you to  have a read and a write  version of the same lock.  Multiple threads can own a read
 * lock as long as another thread does not own the write lock. However, only one thread can own the write lock at a time.
 */
public class ReadMostlyData {
    private int value;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();

    public ReadMostlyData(int value) {
        this.value = value;
    }

    public int getValue() {
        // Use the read lock, so multiple threads may
        // read concurrently
        rLock.lock();
        try {
            return this.value;
        } finally {
            rLock.unlock();
        }
    }

    public void setValue(int value) {
        // Use the write lock, so only one thread can
        // write at a time
        wLock.lock();
        try {
            this.value = value;
        } finally {
            wLock.unlock();
        }
    }
}
