package com.ensolvers.tasks.infraestructure.controller;

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
	
	private CreateTaskService createTaskService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return ResponseEntity.ok(createTaskService.createTask(task));
	}
}
