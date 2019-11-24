package com.github.lazyf1sh.sandbox.spring.config.annotations.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home()
    {
        return "This is home page";
    }
}
