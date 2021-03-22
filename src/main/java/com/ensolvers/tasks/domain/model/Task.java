package com.ensolvers.tasks.domain.model;

public class Task {
	long id;
	String name;

	public Task(long id, String nameTask) {
		this.id = id;
		this.name = nameTask;
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
}
