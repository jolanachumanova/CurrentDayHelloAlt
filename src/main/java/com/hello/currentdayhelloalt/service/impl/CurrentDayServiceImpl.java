package com.hello.currentdayhelloalt.service.impl;

import com.hello.currentdayhelloalt.service.CurrentDayService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
public class CurrentDayServiceImpl implements CurrentDayService {

    @Override
    @Async
    public CompletableFuture<String> getCurrentDay(){
        return CompletableFuture.completedFuture(LocalDate.now().getDayOfWeek().name());
    }
}
