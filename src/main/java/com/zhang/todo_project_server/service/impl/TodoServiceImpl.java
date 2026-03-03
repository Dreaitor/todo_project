package com.zhang.todo_project_server.service.impl;

import com.zhang.todo_project_server.entity.Todo;
import com.zhang.todo_project_server.repository.TodoRepository;
import com.zhang.todo_project_server.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo create(Todo todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(existingTodo);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void clearCompleted() {
        List<Todo> completedTodos = todoRepository.findByCompleted(true);
        todoRepository.deleteAll(completedTodos);
    }

    @Override
    public void toggleAll(boolean completed) {
        List<Todo> todos = todoRepository.findAll();
        todos.forEach(todo -> todo.setCompleted(completed));
        todoRepository.saveAll(todos);
    }
}
