package com.ensolvers.tasks.application.services;

import com.ensolvers.tasks.domain.model.Task;

public interface FindTaskByNameService {
	public Task findTaskByName(String name);
}
