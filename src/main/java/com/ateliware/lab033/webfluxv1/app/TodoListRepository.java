package com.ateliware.lab033.webfluxv1.app;

import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, Integer> {

}
