package com.fibanez.features.thread.synchronizer;

import java.util.concurrent.Phaser;

public class PhaserStartTogetherTaskTest {

    public static void main(String[] args) {
        // Start with 1 registered party
        Phaser phaser = new Phaser(1);
        // Let's start three tasks
        final int TASK_COUNT = 3;
        for (int i = 1; i <= TASK_COUNT; i++) {
            // Register a new party with the phaser for
            // each task
            phaser.register();
            // Now create the task and start it
            String taskName = "Task #" + i;
            PhaserStartTogetherTask task = new PhaserStartTogetherTask(taskName, phaser);
            task.start();
        }
        // Now, deregister the self, so all tasks can
        // advance
        phaser.arriveAndDeregister();
    }
}
