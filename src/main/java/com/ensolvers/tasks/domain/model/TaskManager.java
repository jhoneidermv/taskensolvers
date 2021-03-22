package com.ensolvers.tasks.domain.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ensolvers.tasks.domain.exception.TaskException;
import com.ensolvers.tasks.domain.repository.TaskRepository;

@Component
public class TaskManager {
	private TaskRepository taskRepository;

	public Task createTaskInDomain(Task task) {
		taskRepository.createTask(task);
		return task;
	}

	public Task editTask(Task task) {
		Task foundTask = taskRepository.findTaskByName(task.getName());
		if(foundTask != null) {
			foundTask = task;
			return taskRepository.editTask(foundTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}

	public Task deleteTask(Task task) {
		Task foundTask = taskRepository.findTaskByName(task.getName());
		if(foundTask != null) {
			return taskRepository.deleteTask(foundTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}
	
	public Task findByName(String name) {
		return taskRepository.findTaskByName(name);
	}
	
	public List<Task> listTasks() {
		return taskRepository.listTasks();
	}
}
