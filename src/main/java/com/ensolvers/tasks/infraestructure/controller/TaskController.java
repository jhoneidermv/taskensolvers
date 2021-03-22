package com.ensolvers.tasks.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.tasks.application.services.CreateTaskService;
import com.ensolvers.tasks.domain.model.Task;

@RestController
@RequestMapping(value = "/api")
public class TaskController {
	
	@Autowired
	private CreateTaskService createTaskService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		System.out.print("la tarea trae" + task + " - " + task.getName());
		Task taskfinal = createTaskService.createTask(task);
		if(taskfinal != null) {
			return ResponseEntity.ok(taskfinal);
		} else {
			System.out.println("Es null lo que se ingresó");
			return null;
		}
		
	}
}
