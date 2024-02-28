package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.Todo;

public interface TodoRepository {
    public ArrayList<Todo> getAll();

    public Todo GetById(int id);

    public Todo add(Todo newInfo);

    public Todo edit(int idd, Todo UpdateInfo);

    public void delete(int id);
}