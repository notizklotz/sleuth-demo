package com.example.sleuthdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class PingRestController {

    private final PingService pingService;

    public PingRestController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping("/ping-async-annotated")
    public String pingAsync() throws InterruptedException, ExecutionException {
        return pingService.asyncAnnotated().get();
    }

    @GetMapping("/ping-supply-async")
    public String pingSupplyAsync() throws InterruptedException, ExecutionException {
        return pingService.supplyAsync().get();
    }

    @GetMapping("/ping-sync")
    public String pingSync() throws InterruptedException, ExecutionException {
        return pingService.nonAsyncMethod().get();
    }

}
