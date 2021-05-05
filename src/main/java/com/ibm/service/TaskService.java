package com.ibm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		taskRepository.save(task);
		
	}

	public void deleteTask(String taskId) {
		taskRepository.deleteById(taskId);
	}

	public List<Task> getTask(String taskName) {
		
		return taskRepository.findByNameIgnoreCase(taskName);
	}

	public List<Task> getTaskByPriority(String priority) {
		// TODO Auto-generated method stub
		return taskRepository.findByPriority(priority);
	}

	
}
