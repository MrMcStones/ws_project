package com.rasmus.ws_project.ws_project.controller;

import com.rasmus.ws_project.ws_project.exception.ValidationException;
import com.rasmus.ws_project.ws_project.model.TodoItem;
import com.rasmus.ws_project.ws_project.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todoItem) {
        if (todoItem.getTitle() == null || todoItem.getTitle().isEmpty()) {
            throw new ValidationException("Title cannot be empty");
        }
        return ResponseEntity.status(201).body(todoService.createTodo(todoItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(
            @PathVariable Long id, @RequestBody TodoItem updatedTodo) {
        return ResponseEntity.ok(todoService.updateTodo(id, updatedTodo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
