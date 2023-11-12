package com.hello.currentdayhelloalt.service.impl;

import com.hello.currentdayhelloalt.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Value("${greeting.message}")
    private String message;

    @Override
    @Async
    public CompletableFuture<String> getGreeting(){
        return CompletableFuture.completedFuture(message);
    }
}
