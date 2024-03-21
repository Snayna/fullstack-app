package com.webapp.springboot.backendtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final String greeting = "Hello %s! Welcome to the Backend Tutorial :)";

    @GetMapping("/greeting/{name}")
    public String welcomePersonPathVariable(@PathVariable(value = "name", required = false) String name) {
        return String.format(greeting, name);
    }

    @GetMapping("/greeting")
    public String welcomePersonRequestParam(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(greeting, name);
    }
}
