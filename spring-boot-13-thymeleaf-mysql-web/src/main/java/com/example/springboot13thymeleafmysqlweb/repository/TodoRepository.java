package com.example.springboot13thymeleafmysqlweb.repository;

import com.example.springboot13thymeleafmysqlweb.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
