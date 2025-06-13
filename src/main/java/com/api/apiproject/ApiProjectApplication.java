package com.api.apiproject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class ApiProjectApplication implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(ApiProjectApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        log.info("=======================================================");
        log.info("Application started: {}", applicationContext.getId());
        log.info("http://127.0.0.01:{}{}",
                environment.getProperty("server.port", Integer.class, 0),
                environment.getProperty("server.servlet.context-path", String.class));
        log.info("=======================================================");
    }
}
