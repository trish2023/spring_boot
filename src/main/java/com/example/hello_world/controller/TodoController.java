package com.example.hello_world.controller;

import com.example.hello_world.model.Todo;
import com.example.hello_world.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(@RequestParam(required = false) Boolean completed) {
        if (completed != null) {
            return todoService.getTodosByStatus(completed);
        }
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PatchMapping("/{id}/complete")
    public Todo completeTodo(@PathVariable String id) {
        return todoService.completeTodo(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return "Todo " + id + " deleted";
    }
}
