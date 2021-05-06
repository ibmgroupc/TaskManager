package com.ibm.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class Task {
	private String id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private Date startDate;
	@NotNull
	@NotBlank
	private Date endDate;
	@NotNull
	@NotBlank
	private int priority;
	@NotNull
	private String parent;
	@NotNull
	@NotBlank
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
	
	public void setEndDate(Date endDate) {
		if (endDate.compareTo(new Date()) < 0) {
			throw new IllegalArgumentException("End Date should be future day");
		}
		this.endDate = endDate;
		
	}
	public void setStartDate(Date startDate) {
		if (startDate.compareTo(new Date()) < 0) {
			throw new IllegalArgumentException("Start Date should be future day");
		}
		this.startDate = startDate;
	}
}