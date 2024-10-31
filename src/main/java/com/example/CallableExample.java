package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += i;
                try {
                    Thread.sleep(1000);
                    System.out.println(sum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return sum;
        };

        Future <Integer> future = executor.submit(task);

        try {
            Integer result = future.get();
            System.out.println("sum: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
