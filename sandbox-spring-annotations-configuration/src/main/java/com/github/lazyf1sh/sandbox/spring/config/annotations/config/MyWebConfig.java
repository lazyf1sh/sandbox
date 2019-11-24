package com.github.lazyf1sh.sandbox.spring.config.annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.github.lazyf1sh.sandbox.spring.config.annotations")
public class MyWebConfig
{
}
