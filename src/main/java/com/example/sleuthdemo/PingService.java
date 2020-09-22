package com.example.sleuthdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Component
public class PingService {

    private final Executor executor;

    public PingService(@Qualifier("applicationTaskExecutor") Executor executor) {
        this.executor = executor;
    }

    @Async
    public CompletableFuture<String> asyncAnnotated() throws InterruptedException {
        Thread.sleep(1000);

        return CompletableFuture.completedFuture("pong");
    }

    public CompletableFuture<String> supplyAsync() throws InterruptedException {
        Thread.sleep(1000);

        return CompletableFuture.supplyAsync(() -> "pong", executor);
    }

    public CompletableFuture<String> nonAsyncMethod() throws InterruptedException {
        Thread.sleep(1000);

        return CompletableFuture.completedFuture("pong");
    }
}
