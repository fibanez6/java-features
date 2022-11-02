package com.fibanez.features.thread;

/**
 * You can stop a thread by calling the stop() method. When the stop() method of a thread is called, the JVM throws a
 * ThreadDeath error. Because of throwing this error,  all monitors locked by the thread being stopped are  unlocked.
 * Monitor locks are used to protect some important  shared resources (typically Java objects).  If any of the shared
 * resources protected by the monitors were in inconsistent states when the thread was stopped, other threads may see
 * that  inconsistent state of those resources.  This will result in incorrect  behavior of the program.  This is the
 * reason why the <strong>stop() method has been deprecated</strong>;  you are advised not to use it in your program.
 *
 * You can  suspend  a thread by calling its suspend() method.  To resume a  suspended thread,  you need to call  its
 * resume() method. However,  the suspend() method has been deprecated because it is error-prone,  and it may cause a
 * deadlock. Let’s assume that the suspended thread holds the monitor lock of an object.  The thread that will resume
 * the suspended thread is trying to obtain the monitor lock of the same object. This will result in a deadlock.  The
 * suspended thread  will remain suspended because there is no thread that will resume it,  and the thread that  will
 * resume  it will remain  blocked because the monitor lock  it is trying to obtain is held by the suspended  thread.
 * This is why <strong>the suspend() method has been deprecated</strong>.
 *
 * The resume() method is also deprecated because it is called in conjunction with the suspend() method.  You can use
 * a similar technique to simulate the suspend() and  resume() methods of the Thread class in your program as you did
 * to simulate the stop() method.
 */
public class StopSuspendResume extends Thread {
    private volatile boolean keepRunning = true;
    private boolean suspended = false;

    public synchronized void stopThread() {
        this.keepRunning = false;
        // Notify the thread in case it is suspended when
        // this method is called, so  it will wake up and
        // stop.
        this.notify();
    }

    public synchronized void suspendThread() {
        this.suspended = true;
    }

    public synchronized void resumeThread() {
        this.suspended = false;
        this.notify();
    }

    @Override
    public void run() {
        System.out.println("Thread started...");
        while (keepRunning) {
            try {
                System.out.println("Going to sleep...");
                Thread.sleep(1000);
                // Check for a suspended condition must be
                // made inside a synchronized block to call
                // the wait() method
                synchronized (this) {
                    while (suspended) {
                        System.out.println("Suspended...");
                        this.wait();
                        System.out.println("Resumed...");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped...");
    }

    public static void main(String[] args) {
        StopSuspendResume t = new StopSuspendResume();
        // Start the thread
        t.start();
        // Sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Suspend the thread
        t.suspendThread();
        // Sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Resume the thread
        t.resumeThread();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Stop the thread
        t.stopThread();
    }
}
