package com.development.metindagcilar.parallelism.streams;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MyTask {

    private final int duration;

    public MyTask(int duration) {
        this.duration = duration;
    }

    public int calculate() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(duration * 1000);
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
        return duration;
    }

    public static void runSequentially(List<MyTask> tasks) {
        long start = System.nanoTime();
        List<Integer> result = tasks.stream()
                .map(MyTask::calculate)
                .collect(toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }

    public static void useParallelStream(List<MyTask> tasks) {
        long start = System.nanoTime();
        List<Integer> result = tasks.parallelStream()
                .map(MyTask::calculate)
                .collect(toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
        System.out.println(ForkJoinPool.commonPool().getPoolSize());
    }


    public static void useParallelStreamWithCustomerForkJoinPool(List<MyTask> tasks) throws ExecutionException, InterruptedException {
        ForkJoinPool customThreadPool = new ForkJoinPool(12);

        long start = System.nanoTime();
        List<Integer> result = customThreadPool.submit(() ->
                tasks.parallelStream()
                        .map(MyTask::calculate)
                        .collect(toList())).get();
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }

    public static void useCompletableFuture(List<MyTask> tasks) {
        long start = System.nanoTime();
        List<CompletableFuture<Integer>> futures =
                tasks.stream()
                        .map(t -> CompletableFuture.supplyAsync(() -> t.calculate()))
                        .collect(Collectors.toUnmodifiableList());

        List<Integer> result =
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toUnmodifiableList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }

    public static void useCompletableFutureWithExecutor(List<MyTask> tasks) {
        long start = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(50);
        List<CompletableFuture<Integer>> futures =
                tasks.stream()
                        .map(t -> CompletableFuture.supplyAsync(() -> t.calculate(), executor))
                        .collect(Collectors.toList());

        List<Integer> result =
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
        executor.shutdown();
    }
}

