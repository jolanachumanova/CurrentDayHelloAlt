package com.hello.currentdayhelloalt.integration;

import com.hello.currentdayhelloalt.CurrentDayHelloAltApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest(classes = CurrentDayHelloAltApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "PT30M")
class CurrentDayApiIT {

    @Autowired
    WebTestClient webTestClient;

    @Value("${greeting.message}")
    private String greetingMessage;

    private static final String CURRENT_DAY_ENDPOINT = "/currentDay";

    @Test
    void currentDayTest() {

        String currentDayGreeting = webTestClient.get()
                .uri(CURRENT_DAY_ENDPOINT)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        assertNotNull(currentDayGreeting);
        assertEquals(greetingMessage + LocalDate.now().getDayOfWeek().name(), currentDayGreeting);
    }
}
