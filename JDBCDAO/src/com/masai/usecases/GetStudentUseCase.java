package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class GetStudentUseCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter roll : ");
		int roll = sc.nextInt();

		StudentDao dao = new StudentDaoImpl();
		Student student;
		try {
			student = dao.getStudentByRoll(roll);
			System.out.println(student);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
