package com.zhang.todo_project_server.service;

import com.zhang.todo_project_server.entity.Todo;
import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo create(Todo todo);
    Todo update(Long id, Todo todo);
    void delete(Long id);
    void clearCompleted();
    void toggleAll(boolean completed);
}
