package com.ensolvers.tasks.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.tasks.application.services.CreateTaskService;
import com.ensolvers.tasks.application.services.DeleteTaskService;
import com.ensolvers.tasks.application.services.EditTaskService;
import com.ensolvers.tasks.application.services.ListTasksService;
import com.ensolvers.tasks.application.services.UpdateStateService;
import com.ensolvers.tasks.domain.exception.TaskException;
import com.ensolvers.tasks.domain.model.Task;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api")
public class TaskController {
	
	@Autowired
	private CreateTaskService createTaskService;
	
	@Autowired
	private DeleteTaskService deleteTaskService;
	
	@Autowired
	private EditTaskService editTaskService;
	
	@Autowired
	private UpdateStateService updateStateService;
	
	@Autowired
	private ListTasksService listTaskService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<?> createTask(@RequestBody Task task) throws TaskException{
		try {
			Task taskfinal = createTaskService.createTask(task);
			return ResponseEntity.ok(taskfinal);
		} catch (TaskException e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable (name = "id") long idTask) throws TaskException{
		try {
			Task deletedTask = deleteTaskService.deleteTask(idTask);
			return ResponseEntity.ok(deletedTask);
		} catch (TaskException e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/edit/{id}/{task}")
	public ResponseEntity<?> editTask(@PathVariable(name = "id") long idTask, @PathVariable(name = "task") String nameTask) throws TaskException{
		try {
			Task updatedTask = editTaskService.editTask(new Task(idTask, nameTask));
			return ResponseEntity.ok(updatedTask);
		} catch (Exception e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/updateState/{id}")
	public ResponseEntity<?> updateState(@PathVariable(name = "id") long idTask) {
		Task updatedTask = updateStateService.updateState(idTask);
		return ResponseEntity.ok(updatedTask);
	}
	
	@GetMapping(value = "list")
	public ResponseEntity<?> listTasks(){
		try {
			List<Task> listTask = listTaskService.listTasks();
			return ResponseEntity.ok(listTask);
		} catch (Exception e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
