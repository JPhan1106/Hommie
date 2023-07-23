package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import coding.db.DBUtil;
import coding.entity.Inspection;

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

}
