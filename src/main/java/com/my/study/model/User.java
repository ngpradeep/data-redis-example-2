package com.my.study.model;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String name;
	private Long Salary;

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

	public Long getSalary() {
		return Salary;
	}

	public void setSalary(Long salary) {
		Salary = salary;
	}

	public User(String id, String name, Long salary) {
		super();
		this.id = id;
		this.name = name;
		Salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", Salary=" + Salary + "]";
	}

}
