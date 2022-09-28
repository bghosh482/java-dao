package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class LoginUserCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email : ");
		String email = sc.next();

		System.out.println("Enter password : ");
		String password = sc.next();
		
		StudentDao dao = new StudentDaoImpl();
		try {
			Student s =  dao.loginStudent(email, password);
			System.out.println(s);
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}

	}

}
