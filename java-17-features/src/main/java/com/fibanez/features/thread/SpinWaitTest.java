package com.fibanez.features.thread;

/**
 * However, making a thread sleep or wait has latency.  For a short time wait and to reduce latency,  it is common for a
 * thread to wait in a loop by checking for a certain condition to be true.
 *
 * While spin-wait is  discouraged because of its unnecessary use of resources,  it is commonly needed. In this example,
 * the advantage is that the thread will start processing data as soon as the dataReady variable becomes true.  However,
 * you pay for performance and power consumption because the thread is actively looping.
 *
 * Certain processors can be hinted that a thread is in a spin-wait and,  if possible,  can optimize the resource usage.
 * For example, x86 processors support a PAUSE instruction to indicate a spin-wait. The instruction delays the execution
 * of the next instruction for the thread for a finite small amount of time, thus improving resource usage.
 *
 * The static onSpinWait() method of the Thread class can be used to give a hint to the processor that the caller thread
 * is momentarily not able to proceed, so resource usage can be optimized.  A possible implementation of this method may
 * be no-op when the underlying platform does not support such hints.
 */
public class SpinWaitTest implements Runnable {
    private volatile boolean dataReady = false;

    @Override
    public void run() {
        // Wait while data is ready
        while (!dataReady) {
            // use a spin-wait hint
            Thread.onSpinWait();
        }
        processData();
    }

    private void processData() {
        // Data processing logic goes here
    }

    public void setDataReady(boolean dataReady) {
        this.dataReady = dataReady;
    }
}
