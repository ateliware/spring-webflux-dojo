package com.ateliware.lab033.webfluxv1.app.service;

import com.ateliware.lab033.webfluxv1.app.domain.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, String> {

}
