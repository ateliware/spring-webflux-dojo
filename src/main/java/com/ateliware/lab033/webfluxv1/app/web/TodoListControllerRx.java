package com.ateliware.lab033.webfluxv1.app.web;

import com.ateliware.lab033.webfluxv1.app.domain.TodoList;
import com.ateliware.lab033.webfluxv1.app.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Controller
@RequestMapping("/todoList")
public class TodoListControllerRx {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todo/{id}")
    @ResponseBody
    public Mono<Optional<TodoList>> getTodo(@PathVariable String id) {
        return this.todoListService.getTodo(id);
    }

    @GetMapping("/listAll")
    @ResponseBody
    public Flux<TodoList> listAll() {

        return this.todoListService.findAll();
    }

    @PostMapping("/add")
    @ResponseBody
    public Mono<TodoList> addTodo(@RequestBody TodoList todoList) {
        return this.todoListService.addTodo(todoList.getTitle(), todoList.getDescription());
    }
}
