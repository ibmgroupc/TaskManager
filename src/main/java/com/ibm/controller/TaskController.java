package com.ibm.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Task;
import com.ibm.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	TaskService taskService;
	
	Logger logger = Logger.getLogger(TaskController.class.getName());

	/*
	 * method to create Task
	 * @param task
	 * @param taskId
	 * @param bindingResult
	 **/
	
	@PostMapping("/task")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createTask(@RequestBody @Valid Task task , BindingResult bindingResult) {
		validateTask(bindingResult);
		
		return taskService.createTask(task);
	}


//	private void validateTask(BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			throw new IllegalArgumentException("Something went Wrong , Please try again");
//		}
//	}
//	
	/*
	 * method to create get tasks
	 * 
	 * */
	
	@GetMapping("/task")

	List<Task> getTasks(){
		return taskService.getTasks();
	}
	
	@GetMapping("/task/{name}")
	List<Task> getTask(@PathVariable("name") String taskName) {
		return taskService.getTask(taskName);
	}
	
	@GetMapping("/bug/{priority}")
	List<Task> getTaskByPriority(@PathVariable("priority") String priority) {
		return taskService.getTaskByPriority(priority);
	}
	/*
	 * method to Update task
	 * @param taskId
	 * @param task
	 * */
	@PutMapping("/task/{id}")
	void updateTask(@RequestBody @Valid Task task, BindingResult bindingResult, @PathVariable("id") String taskId) {
	//	validateTask(bindingResult);
		logger.log(Level.INFO, taskId);
		task.setId(taskId);
		taskService.updateTask(task);
	}
	

	/*
	 * method to Delete task
	 * @param taskId
	 * */
	@DeleteMapping("/task/{id}")
		void deleteTask(@PathVariable("id") String taskId) {
			taskService.deleteTask(taskId);
		}
	
}
