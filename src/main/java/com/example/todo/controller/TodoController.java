package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.service.TodoH2Service;
import com.example.todo.model.Todo;

@RestController

public class TodoController{
    @Autowired
    public TodoH2Service todoService;

    @GetMapping("/todos")
    public ArrayList<Todo> getMethod(){
        return todoService.getAll();
    }

    @GetMapping("/todos/{id}")
    public Todo getMethodById(@PathVariable("id") int t_id){
        return todoService.GetById(t_id);
    }

    @PostMapping("/todos")
    public Todo PostMethod(@RequestBody Todo new_todo_info){
        return todoService.add(new_todo_info);
    }

    @PutMapping("/todos/{id}")
    public Todo putMethod(@PathVariable("id") int t_idd,@RequestBody Todo Update_todo_info){
        return todoService.edit(t_idd,Update_todo_info);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteMethod(@PathVariable("id") int tid){
        todoService.delete(tid);
    }
}





