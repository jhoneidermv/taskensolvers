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
		System.out.println("estoy en el domain con la tarea " + task.getId() + " - " + task.getName());
		List<Task> foundTask = taskRepository.findByName(task.getName());
		if(foundTask.isEmpty()) {
			System.out.println("como es nueva voy a agregar la tarea " + task.getId() + " - " + task.getName());
			return taskRepository.createTask(task);
		} else {
			throw new TaskException("La tarea ya existe");
		}
	}

	public Task editTask(Task task) {
		Task foundTask = taskRepository.findTaskById(task.getId());
		if(foundTask != null) {
			foundTask = task;
			return taskRepository.editTask(foundTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}

	public Task deleteTask(Task task) {
		Task foundTask = taskRepository.findTaskById(task.getId());
		if(foundTask != null) {
			return taskRepository.deleteTask(foundTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}
	
	public Task findById(long id) {
		return taskRepository.findTaskById(id);
	}
	
	public List<Task> listTasks() {
		return taskRepository.listTasks();
	}
}
