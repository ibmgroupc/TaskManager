package com.ibm.repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.Task;

public interface TaskRepository extends MongoRepository<Task , String> {

	List<Task> findByNameIgnoreCase(String taskName);

	List<Task> findByPriority(int priority);

	List<Task> findByParent(String taskParent);

	List<Task> findByStartDate(Date startDate);

	List<Task> findByEndDate(Date endDate);

}
