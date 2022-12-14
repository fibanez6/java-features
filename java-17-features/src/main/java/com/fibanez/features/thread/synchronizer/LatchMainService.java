package com.fibanez.features.thread.synchronizer;

import java.util.concurrent.CountDownLatch;

public class LatchMainService extends Thread {
    private final CountDownLatch latch;

    public LatchMainService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Main service is waiting for helper services to start...");
            latch.await();
            System.out.println("Main service has started...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
