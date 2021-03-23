package com.ensolvers.tasks.infraestructure.factory;

import java.util.ArrayList;
import java.util.List;

import com.ensolvers.tasks.domain.model.Task;
import com.ensolvers.tasks.infraestructure.entity.TaskEntity;

public class TaskFactory {
	public static TaskEntity convertTaskdomainToTaskentity(Task task) {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setName(task.getName());
		taskEntity.setId(task.getId());
		taskEntity.setState(task.isState());
		return taskEntity;
	}
	
	public static Task convertTaskentityToTaskdomain(TaskEntity taskEntity) {
		return new Task(taskEntity.getId(), taskEntity.getName(), taskEntity.isState());
	}
	
	public static List<Task> convertListentityToListdomain(List<TaskEntity> listEntity) {
		List<Task> listTask = new ArrayList<>();
		listEntity.forEach(TaskEntity -> listTask.add(convertTaskentityToTaskdomain(TaskEntity)));
		return listTask;
	}
	
}
