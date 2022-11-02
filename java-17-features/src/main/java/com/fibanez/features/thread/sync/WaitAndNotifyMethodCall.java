package com.fibanez.features.thread.sync;

import static com.fibanez.features.thread.sync.DummyMethodUtil.someConditionIsTrue;
import static com.fibanez.features.thread.sync.DummyMethodUtil.someOtherConditionIsTrue;

public class WaitAndNotifyMethodCall {

    private Object objectRef = new Object();

    public synchronized void someMethod_1() throws InterruptedException {
        while (someConditionIsTrue()) {
            this.wait();
        }
        if (someOtherConditionIsTrue()) {
            // Notify all waiting threads
            this.notifyAll();
        }
    }

    public static synchronized void someMethod_2() throws InterruptedException {
        while (someConditionIsTrue()) {
            WaitAndNotifyMethodCall.class.wait();
        }
        if (someOtherConditionIsTrue()) {
            // Notify all waiting threads
            WaitAndNotifyMethodCall.class.notifyAll();
        }
    }

    public void someMethod_3() throws InterruptedException {
        synchronized (objectRef) {
            while (someConditionIsTrue()) {
                objectRef.wait();
            }
            if (someOtherConditionIsTrue()) {
                // Notify all waiting threads
                objectRef.notifyAll();
            }
        }
    }
}
