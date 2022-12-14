package com.fibanez.features.thread.sync;

import static com.fibanez.features.thread.sync.DummyMethodUtil.someConditionIsTrue;

public class WaitMethodCall {
    // Object that is used to synchronize a block
    private Object objectRef = new Object();

    public synchronized void someMethod_1() throws InterruptedException {
        // The thread running here has already acquired
        // the monitor lock on the object represented by
        // the reference this because it is a
        // synchronized non-static method
        // other statements go here
        while (someConditionIsTrue()) {
            // It is ok to call the wait() method on this,
            // because the current thread possesses
            // monitor lock on this
            this.wait();
        }
        // other statements go here
    }

    public static synchronized void someMethod_2() throws InterruptedException {
        // The thread executing here has already acquired
        // the monitor lock on the class object represented
        // by the WaitMethodCall.class reference because it
        // is a synchronized static method
        while (someConditionIsTrue()) {
            // It is ok to call the wait() method on
            // WaitMethodCall.class because the current
            // thread possesses monitor lock on
            // WaitMethodCall.class object
            WaitMethodCall.class.wait();
        }
        // other statements go here
    }

    public void someMethod_3() throws InterruptedException {
        // other statements go here
        synchronized (objectRef) {
            // Current thread possesses monitor lock of
            // objectRef
            while (someConditionIsTrue()) {
                // It is ok to call the wait() method on
                // objectRef because the current thread
                // possesses monitor lock on objectRef
                objectRef.wait();
            }
        }
        // other statements go here
    }
}
