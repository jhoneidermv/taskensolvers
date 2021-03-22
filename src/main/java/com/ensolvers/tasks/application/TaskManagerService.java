package com.ensolvers.tasks.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.tasks.application.services.CreateTaskService;
import com.ensolvers.tasks.application.services.DeleteTaskService;
import com.ensolvers.tasks.application.services.EditTaskService;
import com.ensolvers.tasks.application.services.FindTaskByIdService;
import com.ensolvers.tasks.application.services.ListTasksService;
import com.ensolvers.tasks.domain.model.Task;
import com.ensolvers.tasks.domain.model.TaskManager;

@Service
public class TaskManagerService implements CreateTaskService, DeleteTaskService, EditTaskService, FindTaskByIdService, ListTasksService{

	@Autowired
	private TaskManager taskManager;
	
	@Override
	public List<Task> listTasks() {
		return taskManager.listTasks();
	}

	@Override
	public Task findTaskById(long id) {
		return taskManager.findById(id);
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
		System.out.println("estoy en el service con la tarea " + task.getId() + " - " + task.getName() + " y voy para el domain");
		return taskManager.createTaskInDomain(task);
	}

}
