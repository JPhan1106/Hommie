package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import coding.db.DBUtil;
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
			ps.setDouble(3, payment.getListingFee());
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
	
	public List<Payment> getPaymentsByLandlordId(int landlordId) throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Payment> payments = new ArrayList<>();

	    try {
	        // make connection to mySQL
	        conn = DBUtil.makeConnection();

	        String sql = "SELECT * FROM `payment` WHERE landlord_id = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, landlordId);

	        rs = ps.executeQuery();

	        while (rs.next()) {
	            Payment payment = new Payment();
	            payment.setId(rs.getInt("id"));
	            payment.setLandlordId(rs.getInt("landlord_id"));
	            payment.setRoomId(rs.getInt("room_id"));
	            payment.setListingFee(rs.getDouble("listing_fee"));
	            payment.setListingDate(rs.getTimestamp("listing_date"));
	            payments.add(payment);
	        }

	        return payments;

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
	}
	
	public Payment getPayment(int roomId, int landlordId) throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Payment payment = null;

	    try {
	        // Make connection to mySQL
	        conn = DBUtil.makeConnection();

	        String sql = "SELECT * FROM `payment` WHERE landlord_id = ? AND room_id = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, landlordId);
	        ps.setInt(2, roomId);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            payment = new Payment();
	            payment.setId(rs.getInt("id"));
	            payment.setLandlordId(rs.getInt("landlord_id"));
	            payment.setRoomId(rs.getInt("room_id"));
	            payment.setListingFee(rs.getDouble("listing_fee"));
	            payment.setListingDate(rs.getTimestamp("listing_date"));
	        }

	        return payment;

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
	}

}
