package com.ibm.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.entity.Task;
import com.ibm.repo.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;
	
	public String createTask(Task task) {
		taskRepository.save(task);
		return task.getId();

	}

	public List<Task> getTasks() {
		
		return taskRepository.findAll();
	}

	public void updateTask(@Valid Task task) {
		taskRepository.save(task);
		
	}

	public void deleteTask(String taskId) {
		taskRepository.deleteById(taskId);
	}

	public List<Task> getTask(String taskName) {
		
		return taskRepository.findByNameIgnoreCase(taskName);
	}


	public List<Task> getTaskByPriority(int priority) {

		return taskRepository.findByPriority(priority);
	}

	public List<Task> getTaskByStartDate(Date startDate) {
		
		return taskRepository.findByStartDate(startDate);
	}

	public List<Task> getTaskByParent(String taskParent) {

		return taskRepository.findByParent(taskParent);
	}

	public List<Task> getTaskByEndDate(Date endDate) {
		
		return taskRepository.findByEndDate(endDate);
	}


	

	
}
