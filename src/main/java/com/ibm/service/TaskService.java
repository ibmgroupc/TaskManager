package com.ibm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.service.StatusIllegalArgumentException;
import com.ibm.entity.Task;
import com.ibm.repo.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	StatusIllegalArgumentException statusIllegalArgumentException;
	
	public static  String createTask(Task task) {
		return null;

	}

	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTask(@Valid @RequestBody Task task) {
		// TODO Auto-generated method stub
		taskRepository.save(task);
	}

	public void deleteTask(String taskId) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(taskId);
		
	}

	
}
