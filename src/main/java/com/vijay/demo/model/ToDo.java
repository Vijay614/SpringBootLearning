package com.vijay.demo.model;

import java.util.Date;

import javax.validation.constraints.Size;


public class ToDo {
	int id;
	String name;
	@Size(min=15, message="Enter at least 10 Characters...")
	String desc;
	Date targetDate;
	Boolean isDone;
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ToDo(int id,String name, String desc, Date targetDate, Boolean isDone) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", name=" + name + ", desc=" + desc + ", targetDate=" + targetDate + ", isDone="
				+ isDone + "]";
	}
}
