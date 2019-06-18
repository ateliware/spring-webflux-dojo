package com.ateliware.lab033.webfluxv1.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

public class TodoListController {

    @Autowired
    private TodoListRepository tdr;

    @GetMapping("todolist")
    @ResponseBody
    public Flux<TodoList> list() {
        return this.tdr.findAll();
    }
}
