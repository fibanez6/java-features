package com.fibanez.features.thread;

/**
 * Your program may work the same way as in Listing 5-25 even if you do  not declare  the keepRunning as  volatile.
 * However,  according to the JVM  specification, this  behavior is not  guaranteed. If  the JVM  specification  is
 * implemented correctly, using a volatile variable in this  way ensures the  correct  behavior  for your  program.
 *
 * A volatile variable of long  and double types  is treated atomically for  read and write purposes. Recall that a
 * non-volatile variable  of long and double types is  treated non-atomically. That is,  if two threads are writing
 * two different values, say v1 and v2, to a non-volatile long or  double variable, respectively, your  program may
 * see a value for that variable that  is neither v1 nor v2. However, if that long  or double variable is  declared
 * volatile, your program sees the value v1 or v2 at a given point in time. You cannot make array elements volatile.
 */
public class VolatileVariable extends Thread {
    private volatile boolean keepRunning = true;

    @Override
    public void run() {
        System.out.println("Thread started...");
        // keepRunning is volatile. So, for every read,
        // the thread reads its latest value from the main
        // memory
        while (keepRunning) {
            try {
                System.out.println("Going to sleep ...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped...");
    }
    public void stopThread() {
        this.keepRunning = false;
    }

    public static void main(String[] args) {
        // Create the thread
        VolatileVariable vv = new VolatileVariable();
        // Start the thread
        vv.start();
        // Let the main thread sleep for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Stop the thread
        System.out.println(
            "Going to set the stop flag to true...");
        vv.stopThread();
    }
}