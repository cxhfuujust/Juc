package juc.example.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Future<Integer> future = calculate(5);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.cancel(false);

        try {
                Integer aa = future.get();
            if (!future.isCancelled()){
                Integer integer = future.get();
                System.out.println(integer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("exit!");
        executor.shutdown();
    }

    public static Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("before");
            Thread.sleep(1000);
            System.out.println("after");
            return input * input;
        });
    }
}
