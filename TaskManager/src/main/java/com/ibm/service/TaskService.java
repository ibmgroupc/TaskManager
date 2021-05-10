package com.ibm.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.STATUS;
import com.ibm.entity.Task;
import com.ibm.repo.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;

	public String createTask(Task task) {
		Task savedTask = taskRepository.save(task);
		return savedTask.getId();

	}

	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	public void updateTask(@Valid Task task) {
		STATUS status = task.getStatus();
		Optional<Task> oldTask = taskRepository.findById(task.getId());
		oldTask.ifPresent(oldtask -> {
			STATUS oldstatus = oldtask.getStatus();
			if (oldstatus == STATUS.TODO) {
				if (!(status == STATUS.DONE || status == STATUS.DOING || status == STATUS.TODO)) {
					throw new IllegalArgumentException("STATUS CAN ONLY BE TODO");
				}
			}
			if (oldstatus == STATUS.DOING) {
				if (!(status == STATUS.DONE || status == STATUS.DOING)) {
					throw new IllegalArgumentException("STATUS CAN ONLY BE DOING");
				}
			}
			if (oldstatus == STATUS.DONE) {
				if (!(status == STATUS.DONE)) {
					throw new IllegalArgumentException("TASK IS COMPLETED CAN ONLY BE DELETED");
				}
			}
		});
		taskRepository.save(task);
	}

	public void deleteTask(String taskId) {
		taskRepository.deleteById(taskId);
	}

	public List<Task> getTask(String taskName) {
		return taskRepository.findByNameIsContainingIgnoreCase(taskName);
	}

	public List<Task> getTaskByPriority(int priority) {
		return taskRepository.findByPriority(priority);
	}

	public List<Task> getTaskByStartDate(Date startDate) {
		return taskRepository.findByStartDate(startDate);
	}

	public List<Task> getTaskByParent(String taskParent) {
		return taskRepository.findByParentIsContainingIgnoreCase(taskParent);
	}

	public List<Task> getTaskByEndDate(Date endDate) {
		return taskRepository.findByEndDate(endDate);
	}

	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Optional<Task> getTaskById(String taskId) {
		return taskRepository.findById(taskId);
	}

	public TaskRepository getTaskRepository() {
		return taskRepository;
	}

}
