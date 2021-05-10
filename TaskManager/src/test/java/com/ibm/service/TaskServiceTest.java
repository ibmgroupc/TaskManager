package com.ibm.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
	void testGetTasks() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		taskService.getTaskRepository();
	//	Task task=new Task();
		List<Task> taskList=taskService.getTasks();
		assertNull(taskList);
	}
	
	@Test
	void testGetTaskByParent() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		taskService.getTaskRepository();
		Task task=new Task();
		String parent=taskService.createTask(task);
		List<Task> taskList=taskService.getTaskByParent(parent);
		assertNull(taskList);
	}
	
	@Test
	void testGetTask() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		taskService.getTaskRepository();
		Task task=new Task();
		String name=taskService.createTask(task);
		List<Task> taskList=taskService.getTask(name);
		assertNull(taskList);
	}
	
	@Test
	void testupdateTask() {
		TaskService taskService=new TaskService();
		TaskRepository dummyRepo=new DummyTaskRepository();
		taskService.setTaskRepository(dummyRepo);
		Task task=new Task();
		String taskId=taskService.createTask(task);
		//taskService.updateTask(task);
		assertNotNull(taskId);
	}
}
