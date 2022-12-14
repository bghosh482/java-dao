package com.masai.bean;

public class Student {

	private int roll;
	private int marks;
	private String name;
	private String email;
	private String password;

	public Student() {

	}

	public Student(int roll, int marks, String name, String email, String password) {
		super();
		this.roll = roll;
		this.marks = marks;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", marks=" + marks + ", name=" + name + ", email=" + email + ", password="
				+ password + "]";
	}
	
	

}
