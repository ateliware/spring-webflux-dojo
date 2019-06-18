package com.ateliware.lab033.webfluxv1.app.web;

import com.ateliware.lab033.webfluxv1.app.domain.TodoList;
import com.ateliware.lab033.webfluxv1.app.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/todoList")
public class TodoListControllerRx {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/listAll")
    @ResponseBody
    public Flux<TodoList> listAll() {
        return this.todoListService.findAll();
    }

}
