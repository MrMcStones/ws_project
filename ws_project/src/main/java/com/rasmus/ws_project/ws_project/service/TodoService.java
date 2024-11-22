package com.rasmus.ws_project.ws_project.service;

import com.rasmus.ws_project.ws_project.exception.ResourceNotFoundException;
import com.rasmus.ws_project.ws_project.model.TodoItem;
import com.rasmus.ws_project.ws_project.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public TodoItem createTodo(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodo(Long id, TodoItem updatedTodo) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(updatedTodo.getTitle());
                    existingTodo.setCompleted(updatedTodo.isCompleted());
                    return todoRepository.save(existingTodo);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Todo not found with id " + id);
        }
        todoRepository.deleteById(id);
    }
}
