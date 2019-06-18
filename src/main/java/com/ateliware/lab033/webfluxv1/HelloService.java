package com.ateliware.lab033.webfluxv1;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String hello(String name) {
        return "Hello, " + name + "!";
    }
}
