package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.entity.Student;
import coding.db.DBUtil;

public class StudentService {
	

//	function to use in login
	 public Student getStudentByEmailAndPassword (String email, String password) throws SQLException {
		 Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Student student = null;

			try {
				conn = DBUtil.makeConnection();

				String sql = "SELECT * FROM student WHERE email= ? AND password= ?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, email);
				ps.setString(2, password);

				rs = ps.executeQuery();

				if (rs.next()) {
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					student = new Student(firstName, lastName);
				}

			} finally {

				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
				}

			}
	
			return student;
	
	 }	
	
	
//	 function to use in register
	 public boolean insertStudent(Student student) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;

			try {
//				make connection to mySQL
				conn = DBUtil.makeConnection();

//				create sql for insert
				String sql = "INSERT INTO student(first_name, last_name, phone_number, email, password) value(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);

//				set parameters
				ps.setString(1, student.getFirstName());
				ps.setString(2, student.getLastName());
				ps.setString(3, student.getPhoneNumber());
				ps.setString(4, student.getEmail());
				ps.setString(5, student.getPassword());

				ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			return true;
		}
	 
	 
//	 function to check if email is available for new account
	 public boolean isEmailAvailable(String email) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
//				make connection to mySQL
				conn = DBUtil.makeConnection();

//				create sql for insert
				String sql = "SELECT COUNT(*) FROM student WHERE email =?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, email);
				rs = ps.executeQuery();

				if (rs.next()) {
					int count = rs.getInt(1);
					return count == 0;
				}

			} finally {

				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			}
			return false;
		}
	 
}
