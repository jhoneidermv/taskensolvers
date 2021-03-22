package com.ensolvers.tasks.infraestructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensolvers.tasks.infraestructure.entity.TaskEntity;

@Repository
public interface TaskDAO extends JpaRepository<TaskEntity, Long>{
	@Query(value = "select * from tasks"
			+ " where name = :nameParam", nativeQuery = true)
	public List<TaskEntity> findByName(@Param("nameParam") String name);
}
