package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import coding.db.DBUtil;
import coding.entity.Inspection;
import coding.entity.Room;

public class InspectionService {

	public int insertInspection(Inspection inspection) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO `inspection`(student_id, room_id, enquiry_type, request_time, message) value(?,?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, inspection.getStudentId());
			ps.setInt(2, inspection.getRoomId());
			ps.setString(3, inspection.getEnquiryType());
			ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
			ps.setString(5, inspection.getMessage());

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				int insertedId = rs.getInt(1);
				return insertedId;
			}

			return 0;

		} finally {

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
	}

	public List<Inspection> getAllInspectionByRoomId(int roomId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Inspection inspection = null;
		List<Inspection> list = new ArrayList<Inspection>();

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `inspection` JOIN `user` ON `inspection`.`student_id` = `user`.`id` where `room_id`=? ORDER BY `request_time` DESC");
			ps.setInt(1, roomId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int studentId = rs.getInt("student_id");
				String enquiryType = rs.getString("enquiry_type");
				Timestamp requestTime = rs.getTimestamp("request_time");
				String message = rs.getString("message");
				String studentFirstName = rs.getString("first_name");
				String studentLastName = rs.getString("last_name");
				String studentPhoneNumber = rs.getString("phone_number");
				String studentEmail = rs.getString("email");

				inspection = new Inspection(id, studentId, roomId, enquiryType, requestTime, message, studentFirstName,studentLastName, studentPhoneNumber,studentEmail);

				list.add(inspection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

}
