package edu.famu.fitgen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello World from Java Backend!";
    }
}

