package com.ensolvers.tasks.application.services;

import com.ensolvers.tasks.domain.model.Task;

public interface FindTaskByIdService {
	public Task findTaskById(long ide);
}
