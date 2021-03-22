package com.ensolvers.tasks.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensolvers.tasks.domain.model.Task;
import com.ensolvers.tasks.domain.model.TaskManager;

public class TaskManagerService implements CreateTaskService, DeleteTaskService, EditTaskService, FindTaskByNameService, ListTasksService{

	@Autowired
	private TaskManager taskManager;
	
	@Override
	public List<Task> listTasks() {
		return taskManager.listTasks();
	}

	@Override
	public Task findTaskByName(String name) {
		return taskManager.findByName(name);
	}

	@Override
	public Task editTask(Task task) {
		return taskManager.editTask(task);
	}

	@Override
	public Task deleteTask(Task task) {
		return taskManager.deleteTask(task);
	}

	@Override
	public Task createTask(Task task) {
		return taskManager.createTaskInDomain(task);
	}

}
