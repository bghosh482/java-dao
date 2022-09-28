package com.masai.usecases;

import java.util.List;

import com.masa.dao.StudentDao;
import com.masa.dao.StudentDaoImpl;
import com.masai.bean.Student;
import com.masai.exception.StudentException;

public class GetAllStudentUserCase {

	public static void main(String[] args) {

		StudentDao dao = new StudentDaoImpl();
		try {
			List<Student> students = dao.getAllStudents();
			students.forEach(s -> System.out.println(s));
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
