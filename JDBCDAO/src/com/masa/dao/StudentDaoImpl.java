package com.masa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Student;
import com.masai.exception.StudentException;
import com.masai.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerStudent(String name, int marks, String email, String password) {
		String message = "Not inserted......";

		try (Connection conn = DBUtil.providedConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into student(name,marks,email,password) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, marks);
			ps.setString(3, email);
			ps.setString(4, password);

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Student register sucessfully......";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String registerStudent2(Student student) {

		String message = "Not inserted......";

		try (Connection conn = DBUtil.providedConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into student(name,marks,email,password) values(?,?,?,?)");
			ps.setString(1, student.getName());
			ps.setInt(2, student.getMarks());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Student register sucessfully......";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Student getStudentByRoll(int roll) throws StudentException {

		Student student = null;

		try (Connection conn = DBUtil.providedConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int r = rs.getInt("roll");
				int m = rs.getInt("marks");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("password");
				student = new Student(r, m, n, e, p);
			} else
				throw new StudentException("Student does not exits with this roll " + roll);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());

		}

		return student;
	}

	@Override
	public Student loginStudent(String email, String password) throws StudentException {
		Student student = null;

		try (Connection conn = DBUtil.providedConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				student = new Student();
				student.setRoll(rs.getInt("roll"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getInt("marks"));
				student.setEmail(rs.getString("email"));

			} else {
				throw new StudentException("invalid username and passwors...");
			}

		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}

		return student;
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		List<Student> students = new ArrayList<>();
		
		try (Connection conn = DBUtil.providedConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select * from student");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				
				Student student = new Student();
				student.setRoll(rs.getInt("roll"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getInt("marks"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(students.size()==0)
			throw new StudentException("No student...");
		
		return students;
	}

}
