package com.ensolvers.tasks.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensolvers.tasks.infraestructure.entity.TaskEntity;

@Repository
public interface TaskDAO extends JpaRepository<TaskEntity, String>{
	
}
