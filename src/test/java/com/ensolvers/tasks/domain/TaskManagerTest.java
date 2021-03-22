package com.ensolvers.tasks.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void createTask() {
		//Arrange
		Task task = new Task(1, "crear pruebas unitarias");
		when(taskRepository.createTask(task))
				.thenReturn(new Task(1, "crear pruebas unitarias"));
		
		//Act
		System.out.println("voy a enviar la tarea " + task.getName());
		Task responseTask = taskManager.createTaskInDomain(task);
		
		//Assert
		assertEquals(task.getName(), responseTask.getName());
	}
	
}
