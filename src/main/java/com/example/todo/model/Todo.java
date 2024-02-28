package com.example.todo.model;

public class Todo{
    private int id;
    private String todo;
	private String priority;
    private String status;
    

    public Todo(int i,String t,String p,String s){
        this.id=i;
        this.todo=t;
		this.priority=p;
        this.status=s;
        
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}