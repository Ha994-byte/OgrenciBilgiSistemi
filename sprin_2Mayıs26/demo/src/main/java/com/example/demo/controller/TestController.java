package com.example.demo.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.

        GetMapping;

import org.springframework.web.bind.annotation.
        RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {

        return "KORUNAN ENDPOINT";
    }

    @GetMapping("/role")
    public String role(Authentication authentication) {

        return authentication
                .getAuthorities()
                .toString();
    }
    @GetMapping("/ogrenci-test")
    public String ogrenci() {

        return "OGRENCI GIRDI";
    }
}