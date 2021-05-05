package com.ibm.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.Task;

public interface TaskRepository extends MongoRepository<Task , String> {

	List<Task> findByNameIgnoreCase(String taskName);

	List<Task> findByPriority(String priority);
	
}
