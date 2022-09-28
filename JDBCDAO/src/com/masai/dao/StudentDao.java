package com.masai.dao;

import java.util.List;

import com.masai.bean.Student;
import com.masai.exception.StudentException;

public interface StudentDao {
	
	public String registerStudent(String name, int marks, String email,String password);
	public String registerStudent2(Student student);
	public Student getStudentByRoll(int roll) throws StudentException;
	public Student loginStudent(String email,String password) throws StudentException;
	public List<Student> getAllStudents() throws StudentException;

}
