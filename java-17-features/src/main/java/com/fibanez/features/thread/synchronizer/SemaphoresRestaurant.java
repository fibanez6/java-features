package com.fibanez.features.thread.synchronizer;

import java.util.concurrent.Semaphore;

/**
 * A restaurant with three dining tables.
 *
 * Only  three people  can eat in that restaurant at a time.  When a person arrives at the restaurant,  they must take a
 * token for a table. When they are done eating, they will return the token. Each token represents a dining table.  If a
 * person arrives at the restaurant when all three tables are in use, they must wait until a table becomes available. If
 * a table  is not available  immediately, you have a  choice to wait until one  becomes available  or to go to  another
 * restaurant. Let’s simulate this example using a semaphore. You will have a semaphore with three permits.  Each permit
 * will represent a dining table.
 */
public class SemaphoresRestaurant {
    private final Semaphore tables;

    public SemaphoresRestaurant(int tablesCount) {
        // Create a semaphore using number of tables we
        // have
        this.tables = new Semaphore(tablesCount);
    }

    public void getTable(int customerID) {
        try {
            System.out.println("Customer #" + customerID + " is trying to get a table.");
            // Acquire a permit for a table
            tables.acquire();
            System.out.println("Customer #" + customerID + " got a table.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void returnTable(int customerID) {
        System.out.println("Customer #" + customerID + " returned a table.");
        tables.release();
    }

    public static void main(String[] args) {
        // Create a restaurant with two dining tables
        SemaphoresRestaurant restaurant = new SemaphoresRestaurant(2);
        // Create five customers
        for (int i = 1; i <= 5; i++) {
            RestaurantCustomer c = new RestaurantCustomer(restaurant, i);
            c.start();
        }
    }
}