package com.ateliware.lab033.webfluxv1.app.service;

import com.ateliware.lab033.webfluxv1.app.domain.TodoList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface TodoListService {

    Mono<Optional<TodoList>> getTodo(String id);
    Flux<TodoList> findAll();
    Mono<TodoList> addTodo(String title, String description);

}
