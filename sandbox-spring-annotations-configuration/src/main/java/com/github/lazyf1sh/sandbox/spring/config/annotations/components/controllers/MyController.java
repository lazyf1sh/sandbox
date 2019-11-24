package com.github.lazyf1sh.sandbox.spring.config.annotations.components.controllers;

import com.github.lazyf1sh.sandbox.spring.config.annotations.components.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
    @Autowired
    private MyService myService;

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home()
    {
        myService.run();
        return "This is home page";
    }
}
