package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.Task;

public interface TaskRepository extends MongoRepository<Task , String> {
	
}
