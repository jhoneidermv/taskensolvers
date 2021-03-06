package com.ensolvers.tasks.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.tasks.domain.model.Task;
import com.ensolvers.tasks.domain.repository.TaskRepository;
import com.ensolvers.tasks.infraestructure.entity.TaskEntity;
import com.ensolvers.tasks.infraestructure.factory.TaskFactory;

@Service
public class TaskDAOImpl implements TaskRepository {

	@Autowired
	private TaskDAO taskDAO;

	@Override
	public Task createTask(Task task) {
		TaskEntity taskEntity = taskDAO.save(TaskFactory.convertTaskdomainToTaskentity(task));
		return TaskFactory.convertTaskentityToTaskdomain(taskEntity);
	}

	@Override
	public Task editTask(Task task) {
		TaskEntity taskEntity = taskDAO.save(TaskFactory.convertTaskdomainToTaskentity(task));
		return TaskFactory.convertTaskentityToTaskdomain(taskEntity);
	}

	@Override
	public Task deleteTask(Task task) {
		taskDAO.delete(TaskFactory.convertTaskdomainToTaskentity(task));
		return task;
	}

	@Override
	public Task findTaskById(long id) {
		Optional<TaskEntity> taskEntity = taskDAO.findById(id);
		if(taskEntity.isPresent()) {
			return TaskFactory.convertTaskentityToTaskdomain(taskEntity.get());
		} else {
			return null;
		}
	}

	@Override
	public List<Task> listTasks() {
		return TaskFactory.convertListentityToListdomain(taskDAO.findAll());
	}

	@Override
	public List<Task> findByName(String name) {
		return TaskFactory.convertListentityToListdomain(taskDAO.findByName(name));
	}

	@Override
	public Task updateState(Task task) {
		task.setState(!task.isState());
		TaskEntity taskEntity = taskDAO.save(TaskFactory.convertTaskdomainToTaskentity(task));
		return TaskFactory.convertTaskentityToTaskdomain(taskEntity);
	}

	

}
