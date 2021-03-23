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
		List<Task> foundedTask = taskRepository.findByName(task.getName());
		if(foundedTask.isEmpty()) {
			return taskRepository.createTask(task);
		} else {
			throw new TaskException("La tarea ya existe");
		}
	}

	public Task editTask(Task task) {
		Task foundedTask = taskRepository.findTaskById(task.getId());
		if(foundedTask != null) {
			foundedTask = task;
			return taskRepository.editTask(foundedTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}

	public Task deleteTask(long idTask) {
		Task foundedTask = taskRepository.findTaskById(idTask);
		if(foundedTask != null) {
			return taskRepository.deleteTask(foundedTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}
	
	public Task findById(long id) {
		return taskRepository.findTaskById(id);
	}
	
	public List<Task> listTasks() {
		List<Task> listTask = taskRepository.listTasks();
		if(!listTask.isEmpty()) {
			return listTask;
		} else {
			throw new TaskException("No existen tareas");
		}
	}
	
	public Task updateState(long id) {
		Task foundedTask = taskRepository.findTaskById(id);
		if(foundedTask != null) {
			return taskRepository.updateState(foundedTask);
		} else {
			throw new TaskException("Tarea no encontrada");
		}
	}
}
