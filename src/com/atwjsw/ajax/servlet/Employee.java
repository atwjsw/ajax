package com.atwjsw.ajax.servlet;

public class Employee {
	
	private String number;
	private String name;
	private String job;
	
	public Employee() {		
	}
	
	public Employee(String number, String name, String job) {
		this.number = number;
		this.name = name;
		this.job = job;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", job=" + job + "]";
	}
}
