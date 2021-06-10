package com.development.metindagcilar.parallelism.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class MyTaskTest {

    List<MyTask> tasks = IntStream.range(0, 100)
            .mapToObj(i -> new MyTask(1))
            .collect(toList());

    @Test
    public void runSequentially(){
        MyTask.runSequentially(tasks);
    }

    @Test
    public void useParallelStream(){
        MyTask.useParallelStream(tasks);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void useParallelStreamWithCustomerForkJoinPool() throws ExecutionException, InterruptedException {
        MyTask.useParallelStreamWithCustomerForkJoinPool(tasks);
    }

    @Test
    public void useCompletableFuture() {
        MyTask.useCompletableFuture(tasks);
    }

    @Test
    public void useCompletableFutureWithExecutor() {
        MyTask.useCompletableFutureWithExecutor(tasks);

    }
}