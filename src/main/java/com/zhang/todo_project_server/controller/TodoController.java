package com.zhang.todo_project_server.controller;

import com.zhang.todo_project_server.entity.Todo;
import com.zhang.todo_project_server.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @PatchMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PostMapping("/clear-completed")
    public void clearCompleted() {
        todoService.clearCompleted();
    }

    @PostMapping("/toggle-all")
    public void toggleAll(@RequestBody boolean completed) {
        todoService.toggleAll(completed);
    }
}
