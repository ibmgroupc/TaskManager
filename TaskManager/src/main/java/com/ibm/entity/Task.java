package com.ibm.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.ibm.service.StatusIllegalArgumentException;

public class Task {
	@Id
	private String id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	@NotNull
	private int priority;
	@NotNull
	private String parent;
	@NotNull
	private STATUS status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public OCCURANCE getOccurance() {
		return occurance;
	}

	public void setOccurance(OCCURANCE occurance) {
		this.occurance = occurance;
	}

	private TYPE type;
	private OCCURANCE occurance;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEndDate(Date endDate) {
		if (endDate.compareTo(getStartDate()) <= 0) {
			throw new StatusIllegalArgumentException("End Date should be future day or same as start date");
		}
		this.endDate = endDate;

	}

	public void setStartDate(Date startDate) {
		if (!(startDate.after(new Date()))) {
			throw new StatusIllegalArgumentException("Start Date should not be past date");
		}
		this.startDate = startDate;
	}
}