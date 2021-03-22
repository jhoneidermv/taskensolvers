package com.ensolvers.tasks.domain.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensolvers.tasks.domain.exception.TaskException;
import com.ensolvers.tasks.domain.repository.TaskRepository;

@Component
public class TaskManager {
	@Autowired
	private TaskRepository taskRepository;

	public Task createTaskInDomain(Task task) {
		System.out.println("llegué a taskmanager con la tarea " + task.getName() + "y voy para el repository");
		return taskRepository.createTask(task);
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
