package com.masai.usecases;

import java.util.Scanner;

import com.masa.dao.StudentDao;
import com.masa.dao.StudentDaoImpl;

public class RegisterStudentUseCase {

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
		String m = dao.registerStudent(name, marks, email, password);
		System.out.println(m);
		
		

	}

}
