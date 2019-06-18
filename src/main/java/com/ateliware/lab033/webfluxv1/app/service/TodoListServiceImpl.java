package com.ateliware.lab033.webfluxv1.app.service;

import com.ateliware.lab033.webfluxv1.app.domain.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Component("todoListService")
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    @Qualifier("jdbcScheduler")
    private Scheduler jdbdScheduler;

    @Override
    public Mono<TodoList> getTodo(Integer id) {
        return null;
    }

    @Override
    public Flux<TodoList> findAll() {

        Flux<TodoList> defer = Flux.defer( () -> Flux.fromIterable(this.todoListRepository.findAll()) );
        return defer.subscribeOn(jdbdScheduler);
    }

    @Override
    public Mono<TodoList> addTodo(String title, String description) {
        return null;
    }
}
