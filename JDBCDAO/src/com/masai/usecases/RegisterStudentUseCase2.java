package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

public class RegisterStudentUseCase2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter marks : ");
		int marks = sc.nextInt();
		System.out.println("Enter email : ");
		String email = sc.next();

		System.out.println("Enter password : ");
		String password = sc.next();

		StudentDao dao = new StudentDaoImpl();
		
		Student student = new Student();
		student.setEmail(email);
		student.setMarks(marks);
		student.setName(name);
		student.setPassword(password);
		
		String m = dao.registerStudent2(student);
		System.out.println(m);
		
		

	}

}
