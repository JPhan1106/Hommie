package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.db.DBUtil;
import coding.entity.Landlord;

public class LandlordService {

//	function to use in login
	 public Landlord getLandlordByEmailAndPassword (String email, String password) throws SQLException {
		 Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Landlord landlord = null;

			try {
				conn = DBUtil.makeConnection();

				String sql = "SELECT * FROM landlord WHERE email= ? AND password= ?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, email);
				ps.setString(2, password);

				rs = ps.executeQuery();

				if (rs.next()) {
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					landlord = new Landlord (firstName, lastName);
				}

			} finally {

				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
				}

			}
	
			return landlord;
	
	 }	
	
	 
//	 function to use in register
	 public boolean insertLandlord(Landlord landlord) throws SQLException { 
			Connection conn = null;
			PreparedStatement ps = null;

			try {
//				make connection to mySQL
				conn = DBUtil.makeConnection();

//				create sql for insert
				String sql = "INSERT INTO landlord(first_name, last_name, phone_number, email, password) value(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);

//				set parameters
				ps.setString(1, landlord.getFirstName());
				ps.setString(2, landlord.getLastName());
				ps.setString(3, landlord.getPhoneNumber());
				ps.setString(4, landlord.getEmail());
				ps.setString(5, landlord.getPassword());

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
				String sql = "SELECT COUNT(*) FROM landlord WHERE email =?";
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