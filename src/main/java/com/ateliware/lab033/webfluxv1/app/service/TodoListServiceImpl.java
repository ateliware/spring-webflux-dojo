package com.ateliware.lab033.webfluxv1.app.service;

import com.ateliware.lab033.webfluxv1.app.domain.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Component("todoListService")
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    @Qualifier("jdbcScheduler")
    private Scheduler jdbdScheduler;

    @Override
    public Mono<Optional<TodoList>> getTodo(String id) {

        Mono<Optional<TodoList>> todoList = Mono
                                  .defer(() -> Mono.just(this.todoListRepository.findById(id)))
                                  .subscribeOn(jdbdScheduler);
        return todoList;
    }

    @Override
    public Flux<TodoList> findAll() {

        Flux<TodoList> defer = Flux.defer(() -> Flux.fromIterable(this.todoListRepository.findAll()));
        return defer.subscribeOn(jdbdScheduler);
    }

    @Override
    public Mono<TodoList> addTodo(String title, String description) {

        return Mono.fromCallable(() -> transactionTemplate.execute(status -> {
            TodoList todoList = new TodoList(title, description);
            TodoList savedTodoList = todoListRepository.save(todoList);
            return savedTodoList;
        })).subscribeOn(jdbdScheduler);
    }
}
