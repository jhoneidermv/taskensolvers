package com.ensolvers.tasks.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ensolvers.tasks.domain.exception.TaskException;
import com.ensolvers.tasks.domain.model.Task;
import com.ensolvers.tasks.domain.model.TaskManager;
import com.ensolvers.tasks.domain.repository.TaskRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskManagerTest {
	
	@Mock
	private TaskRepository taskRepository;
	
	@InjectMocks
	private TaskManager taskManager;
	
	@Test
	public void createTaskTest() {
		//Arrange
		Task task = new Task(1, "crear pruebas unitarias");
		when(taskRepository.createTask(task))
				.thenReturn(new Task(1, "crear pruebas unitarias"));
		
		//Act
		Task responseTask = taskManager.createTaskInDomain(task);
		
		//Assert
		assertEquals(task.getName(), responseTask.getName());
	}
	
	@Test
	public void createExistingTaskTest() {
		//Arrange
		Task task = new Task(1, "crear pruebas unitarias");
		List<Task> list = new ArrayList<>();
		list.add(task);
		when(taskRepository.findByName(task.getName()))
		.thenReturn(list);
		
		//Act
		try {
			taskManager.createTaskInDomain(task);
		} catch(TaskException e) {
			//Assert
			assertEquals("La tarea ya existe", e.getMessage());
		}
	}
	
	@Test
	public void editExistingTaskTest() {
		//Arrange
		Task task = new Task(1, "tarea asignada", false);
		when(taskRepository.findTaskById(task.getId())).thenReturn(task);
		when(taskRepository.editTask(task)).thenReturn(task);
		
		//Act
		Task taskExisting = taskManager.editTask(task);
		
		//Assert
		assertEquals(taskExisting, task);
	}
	
	@Test
	public void editNonExistentTaskTest() {
		//Arrange
		Task task = new Task(1, "tarea asignada", false);
		when(taskRepository.findTaskById(task.getId())).thenReturn(new Task(2, "otra tarea"));
		
		//Act
		try {
			taskManager.editTask(task);
		} catch(TaskException e) {
			//Assert
			assertEquals("Tarea no encontrada", e.getMessage());
		}
	}
	
	@Test
	public void deleteTaskTest() {
		//Arrange
		Task task = new Task(1, "tarea asignada", false);
		when(taskRepository.deleteTask(task)).thenReturn(task);
		when(taskRepository.findTaskById(task.getId())).thenReturn(task);
		
		//Act
		Task deletedTask = taskManager.deleteTask(task.getId());
		
		//Assert
		assertEquals(task, deletedTask);
	}
	
	@Test
	public void deleteNonExistentTaskTest() {
		//Arrange
		Task task = new Task(1, "tarea asignada", false);
		when(taskRepository.findTaskById(task.getId())).thenReturn(null);
		
		//Act
		try {
			taskManager.deleteTask(task.getId());
		} catch(TaskException e) {
			//Assert
			assertEquals("Tarea no encontrada", e.getMessage());
		}
	}
	
	@Test
	public void updateStateTaskTest() {
		//Arrange
		Task task = new Task(1, "tarea asignada", false);
		when(taskRepository.findTaskById(task.getId())).thenReturn(task);
		when(taskRepository.updateState(task)).thenReturn(task);
		
		//Act
		Task updatedTask = taskManager.updateState(task.getId());
		
		//Assert
		assertEquals(task, updatedTask);
	}
	
	@Test
	public void updateStateNonExistentTaskTest() {
		//Arrange
		Task task = new Task(1, "tarea asignada", false);
		when(taskRepository.findTaskById(task.getId())).thenReturn(null);
		
		//Act
		try {
			taskManager.updateState(task.getId());
		} catch(TaskException e) {
			//Assert
			assertEquals("Tarea no encontrada", e.getMessage());
		}
		
	}
}
