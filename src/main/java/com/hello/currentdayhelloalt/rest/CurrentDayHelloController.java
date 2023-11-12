package com.hello.currentdayhelloalt.rest;

import com.hello.currentdayhelloalt.service.CurrentDayService;
import com.hello.currentdayhelloalt.service.GreetingService;
import com.hello.currentdayhelloalt.service.exception.GreetingAndCurrentDayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CurrentDayHelloController {

    private final GreetingService greetingService;
    private final CurrentDayService currentDayService;

    @GetMapping(value = "/currentDay")
    public ResponseEntity<String> getCurrentDayWithGreeting() {
        try {
            CompletableFuture<String> greeting = greetingService.getGreeting();
            CompletableFuture<String> currentDay = currentDayService.getCurrentDay();

            CompletableFuture.allOf(greeting, currentDay).join();
            return ResponseEntity.ok(greeting.get() + currentDay.get());

        }catch (Exception e){
            log.error("Error while getting greeting and current day: {}", e.getMessage());
            throw new GreetingAndCurrentDayException(e.getMessage());
        }

    }

}
