package com.ibm.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void updateTask(@Valid Task task) {
		// TODO Auto-generated method stub
		
	}

	
}
