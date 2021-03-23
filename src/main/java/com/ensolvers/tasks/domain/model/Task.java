package com.ensolvers.tasks.domain.model;

public class Task {
	private long id;
	private String name;
	private boolean state;

	public Task(long id, String nameTask) {
		this.id = id;
		this.name = nameTask;
		state = false;
	}
	
	public Task(long id, String nameTask, boolean state) {
		this.id = id;
		this.name = nameTask;
		this.state = state;
	}
	
	public Task() {}
	
	public String getName() {
		return name;
	}

	public void setName(String nameTask) {
		this.name = nameTask;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
