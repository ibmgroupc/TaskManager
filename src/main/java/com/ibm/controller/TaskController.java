package com.ibm.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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
	
	@PostMapping("/test")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createTask(@RequestBody @Valid Task task , BindingResult bindingResult) {
		validateTask(bindingResult);
		
		return TaskService.createTask(task);
	}

	private void validateTask(BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went Wrong , Please try again");
		}
	}
	
	@GetMapping("/task/")
	List<Task> getTasks(){
		return taskService.getTasks();
	}
	
	@PutMapping("/bug/{id}")
	void updateTask(@RequestBody @Valid Task task, BindingResult bindingResult, @PathVariable("id") String taskId) {
		validateTask(bindingResult);
		logger.log(Level.INFO, taskId);
		task.setId(taskId);
		taskService.updateTask(task);
	}
	

}
