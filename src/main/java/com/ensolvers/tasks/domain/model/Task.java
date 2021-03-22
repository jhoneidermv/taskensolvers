package com.ensolvers.tasks.domain.model;

public class Task {
	String name;

	public Task(String nameTask) {
		this.name = nameTask;
	}
	
	public Task() {}
	
	public String getName() {
		return name;
	}

	public void setName(String nameTask) {
		this.name = nameTask;
	}
}
