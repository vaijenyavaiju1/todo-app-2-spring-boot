package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;

@Service

public class TodoH2Service implements TodoRepository {

	@Autowired
	private JdbcTemplate db;

	@Override
	public ArrayList<Todo> getAll() {
		List<Todo> todoList = db.query("select * from todolist", new TodoRowMapper());
		ArrayList<Todo> TodoArr = new ArrayList<>(todoList);

		return TodoArr;
	}

	@Override
	public Todo GetById(int id) {
		try {
			Todo existingTodoInfo = db.queryForObject("select * from todolist where id=?", new TodoRowMapper(), id);
			return existingTodoInfo;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Todo add(Todo newInfo) {
		db.update("insert into todolist(todo,priority,status) values (?,?,?)", newInfo.getTodo(), newInfo.getPriority(),
				newInfo.getStatus());

		// retreive this row and return this

		Todo savedTodo = db.queryForObject("select * from todolist where todo=? and status=?", new TodoRowMapper(),
				newInfo.getTodo(), newInfo.getStatus());

		return savedTodo;
	}

	@Override
	public Todo edit(int idd, Todo UpdateInfo) {
		if (UpdateInfo.getTodo() != null) {
			db.update("update todolist set todo=? where id=?", UpdateInfo.getTodo(), idd);
		}
		if (UpdateInfo.getStatus() != null) {
			db.update("update todolist set status=? where id=?", UpdateInfo.getStatus(), idd);
		}
		if (UpdateInfo.getPriority() != null) {
			db.update("update todolist set priority=? where id=?", UpdateInfo.getPriority(), idd);
		}
		return GetById(idd);
	}

	@Override
	public void delete(int id) {
		db.update("delete from todolist where id=?", id);

	}

}