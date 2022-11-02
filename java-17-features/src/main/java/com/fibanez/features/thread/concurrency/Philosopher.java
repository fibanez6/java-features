package com.fibanez.features.thread.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The dining philosophers problem using the explicit lock constructs.
 *
 * The problem goes like this:
 *
 * Five  philosophers spend all  of their time  either thinking or eating.  They sit around a  circular table with  five
 * chairs and five forks, as shown in Figure 5-7. There are only five forks,  and all five philosophers need to pick the
 * two nearest (one from their left and one from their right) forks to eat.
 *
 * Once a philosopher finishes eating, he puts down both forks and starts thinking.  A philosopher cannot pick up a fork
 * if his neighbor is using it. What happens if each of the five philosophers picks up one fork from his right and waits
 * for  his left fork to be  released by his neighbor? This would be a  deadlock situation,  and no philosopher would be
 * able to eat. This deadlock condition can be avoided easily by using the tryLock() method of the Lock interface.  This
 * method returns immediately, and it never blocks. If the lock is available, it gets the lock and returns true.  If the
 * lock is not available,  it returns false.  The class can be used to model the philosophers assuming that an object of
 * the ReentrantLock class represents a fork.
 */
public class Philosopher {
    private final Lock leftFork;
    private final Lock rightFork;
    private final String name; // Philosopher's name

    public Philosopher(Lock leftFork, Lock rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    public void think() {
        System.out.println(name + " is thinking...");
    }

    /**
     * If you can get only one fork and not the other, you put down the one you got so others can have it.
     */
    public void eat() {
        // Try to get the left fork
        if (leftFork.tryLock()) {
            try {
                // try to get the right fork
                if (rightFork.tryLock()) {
                    try {
                        // Got both forks. Eat now
                        System.out.println(name + " is eating...");

                        Thread.sleep(1000);
                        think();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // release the right fork
                        rightFork.unlock();
                    }
                }
            } finally {
                // release the left fork
                leftFork.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock fork1 = new ReentrantLock();
        Lock fork2 = new ReentrantLock();
        Lock fork3 = new ReentrantLock();
        Lock fork4 = new ReentrantLock();
        Lock fork5 = new ReentrantLock();

        Philosopher p1 = new Philosopher(fork1, fork2, "John");
        Philosopher p2 = new Philosopher(fork2, fork3, "Wallace");
        Philosopher p3 = new Philosopher(fork3, fork4, "Charles");
        Philosopher p4 = new Philosopher(fork4, fork5, "Williams");
        Philosopher p5 = new Philosopher(fork5, fork1, "Andy");

        Thread t1 = new Thread( () -> p1.eat());
        Thread t2 = new Thread( () -> p2.eat());
        Thread t3 = new Thread( () -> p3.eat());
        Thread t4 = new Thread( () -> p4.eat());
        Thread t5 = new Thread( () -> p5.eat());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
    }
}
