package com.api.apiproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StatusController {

    @GetMapping("/")
    public String index() {
        log.info("index");
        return "index ok";
    }

    @GetMapping("/status")
    public String status() {
        log.info("status check");
        return "status ok";
    }

}
