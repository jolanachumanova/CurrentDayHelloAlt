package com.hello.currentdayhelloalt.service;

import java.util.concurrent.CompletableFuture;

public interface CurrentDayService {
    CompletableFuture<String> getCurrentDay();
}
