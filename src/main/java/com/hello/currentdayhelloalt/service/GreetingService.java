package com.hello.currentdayhelloalt.service;

import java.util.concurrent.CompletableFuture;

public interface GreetingService {
    CompletableFuture<String> getGreeting();
}
