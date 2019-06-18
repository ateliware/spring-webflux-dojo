package com.ateliware.lab033.webfluxv1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@SpringBootApplication
public class WebfluxV1Application implements CommandLineRunner {

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(WebfluxV1Application.class, args);
    }

    @Bean
    public Scheduler jdbcScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(1));
    }

    @Override
    public void run(String... args) {
        System.out.println(helloService.hello("Felipero no lab033"));
    }
}
