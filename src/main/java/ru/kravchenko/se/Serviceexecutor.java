package ru.kravchenko.se;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Serviceexecutor {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Runnable, return void, nothing, submit and run the task async
        executor.submit(() -> System.out.println("I'm Runnable task."));

        // Callable, return a future, submit and run the task async
        Future<Integer> futureTask1 = executor.submit(() -> {
            System.out.println("I'm Callable task.");
            return 1 + 1;
        });
    }

}
