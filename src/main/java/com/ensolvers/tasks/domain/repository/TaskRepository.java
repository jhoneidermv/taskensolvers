package com.ensolvers.tasks.domain.repository;

import java.util.List;

import com.ensolvers.tasks.domain.model.Task;

public interface TaskRepository {
	public Task createTask(Task task);
	public Task editTask(Task task);
	public Task deleteTask(Task task);
	public Task findTaskByName(String name);
	public List<Task> listTasks();
}
