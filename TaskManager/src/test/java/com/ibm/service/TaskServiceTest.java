package com.ibm.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibm.entity.Task;
import com.ibm.repo.TaskRepository;

class TaskServiceTest {

	@Test
	void testCreateTask() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		Task task=new Task();
		String taskId=taskService.createTask(task);
		assertNotNull(taskId);
	}
   
	@Test
	void testGetTask() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		Task task=new Task();
		String taskId=taskService.createTask(task);
		assertNotNull(taskId);
	}
	
	@Test
	void testupdateTask() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		Task task=new Task();
		String taskId=taskService.createTask(task);
		assertNotNull(taskId);
	}
}
