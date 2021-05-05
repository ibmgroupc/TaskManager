package com.ibm.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Task {
	@NotNull
	private String id;
	@NotNull
	private String name;
	private Date startDate;
	private Date endDate;
	private int priority;
	private String parent;
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
			throw new IllegalArgumentException("End Date cannot be past day");
		}
		this.endDate = endDate;
		
	}
	public void setStartDate(Date startDate) {
		if (startDate.compareTo(new Date()) < 0) {
			throw new IllegalArgumentException("Start Date cannot be future day");
		}
		this.startDate = startDate;
	}
}