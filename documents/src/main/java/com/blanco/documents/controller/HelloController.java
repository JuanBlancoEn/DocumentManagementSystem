package com.blanco.documents.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "¡Hola! El servidor está funcionando 😊";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
