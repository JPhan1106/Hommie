package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coding.db.DBUtil;
import coding.entity.Inspection;
import coding.entity.Payment;

public class PaymentService {

	public int insertPayment(Payment payment) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO `payment`(landlord_id, room_id, listing_fee, listing_date) value(?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, payment.getLandlordId());
			ps.setInt(2, payment.getRoomId());
			ps.setInt(3, payment.getListingFee());
			ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));

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

	public List<Map<String, Object>> getPaymentsByLandlordId(int landlordId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			// make connection to mySQL
			conn = DBUtil.makeConnection();

			// Join the payment table with the room table and select the room.title column
			String sql = "SELECT payment.*, room.title FROM payment JOIN room ON payment.room_id = room.id WHERE payment.landlord_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, landlordId);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int roomId = rs.getInt("room_id");
				int listingFee = rs.getInt("listing_fee");
				Timestamp listingDate = rs.getTimestamp("listing_date");
				String roomTitle = rs.getString("title"); // Assuming the title column is named "title"

				Payment payment = new Payment(id, landlordId, roomId, listingFee, listingDate);
				Map<String, Object> map = new HashMap<>();
				map.put("payment", payment);
				map.put("roomTitle", roomTitle);

				list.add(map);
			}
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
