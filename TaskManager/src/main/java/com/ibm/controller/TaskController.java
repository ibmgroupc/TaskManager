package com.ibm.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	 * 
	 * @param task
	 * 
	 * @param taskId
	 * 
	 * @param bindingResult
	 **/
	@CrossOrigin
	@PostMapping("/task")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createTask(@RequestBody @Valid Task task, BindingResult bindingResult) {
		validateTask(bindingResult);
		return taskService.createTask(task);
	}

	/*
	 * For Validate task
	 */
	private void validateTask(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went Wrong , Please try again");
		}
	}

	/*
	 * method to fetch get tasks
	 */
	@CrossOrigin
	@GetMapping("/task")
	List<Task> getTasks() {
		return taskService.getTasks();
	}

	/*
	 * method to fetch task by name
	 * 
	 * @param taskName
	 */
	@CrossOrigin
	@GetMapping("/task/name/{name}")
	List<Task> getTask(@PathVariable("name") String taskName) {
		return taskService.getTask(taskName);
	}

	/*
	 * method to fetch task by name
	 * 
	 * @param taskId
	 */
	@CrossOrigin
	@GetMapping("/task/id/{id}")
	Optional<Task> getTaskById(@PathVariable("id") String taskId) {
		return taskService.getTaskById(taskId);
	}

	/*
	 * method to fetch task by priority
	 * 
	 * @param priority
	 */
	@CrossOrigin
	@GetMapping("/task/priority/{priority}")
	List<Task> getTaskByPriority(@PathVariable("priority") int priority) {
		return taskService.getTaskByPriority(priority);
	}

	/*
	 * method to fetch task by StartDate
	 * 
	 * @param startDate
	 */
	@CrossOrigin
	@GetMapping("/task/startDate/{startDate}")
	List<Task> getTaskBystartDate(
			@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate) {
		System.out.println(startDate);
		// startDate.set
		return taskService.getTaskByStartDate(startDate);
	}

	/*
	 * method to fetch task by End Date
	 * 
	 * @param endDate
	 */
	@CrossOrigin
	@GetMapping("/task/endDate/{endDate}")
	List<Task> getTaskByendDate(@PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		return taskService.getTaskByEndDate(endDate);
	}

	/*
	 * method to fetch task by Parent
	 * 
	 * @param taskParent
	 */
	@CrossOrigin
	@GetMapping("/task/parent/{parent}")
	List<Task> getTaskByParent(@PathVariable("parent") String taskParent) {
		return taskService.getTaskByParent(taskParent);
	}

	/*
	 * method to Update task
	 * 
	 * @param taskId
	 * 
	 * @param task
	 */
	@CrossOrigin
	@PutMapping("/task/{id}")
	void updateTask(@RequestBody @Valid Task task, BindingResult bindingResult, @PathVariable("id") String taskId) {
		validateTask(bindingResult);
		logger.log(Level.INFO, taskId);
		task.setId(taskId);
		taskService.updateTask(task);
	}

	/*
	 * method to Delete task
	 * 
	 * @param taskId
	 */
	@CrossOrigin
	@DeleteMapping("/task/{id}")
	void deleteTask(@PathVariable("id") String taskId) {
		taskService.deleteTask(taskId);
	}

}