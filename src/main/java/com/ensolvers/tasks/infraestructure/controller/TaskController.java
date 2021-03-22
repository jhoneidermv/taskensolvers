package com.ensolvers.tasks.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.tasks.application.services.CreateTaskService;
import com.ensolvers.tasks.domain.exception.TaskException;
import com.ensolvers.tasks.domain.model.Task;

@RestController
@RequestMapping(value = "/api")
public class TaskController {
	
	@Autowired
	private CreateTaskService createTaskService;
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<?> createTask(@RequestBody Task task) throws TaskException{
		try {
			Task taskfinal = createTaskService.createTask(task);
			return ResponseEntity.ok(taskfinal);
		} catch (TaskException e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
