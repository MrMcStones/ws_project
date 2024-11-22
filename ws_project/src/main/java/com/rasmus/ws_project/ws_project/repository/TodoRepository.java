package com.rasmus.ws_project.ws_project.repository;

import com.rasmus.ws_project.ws_project.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

// Gränssnitt som hanterar operationer i databas för 2Do's
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
