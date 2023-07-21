package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.db.DBUtil;
import coding.entity.Room;

public class LandlordRoomService {

	public List<Room> getAllAvailableRoomsByLandlordId(int landlordId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `room` where `landlord_id`=? and `status`='available'");
			ps.setInt(1, landlordId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int countBed = rs.getInt("count_bed");
				int countBath = rs.getInt("count_bath");
				String image1Url = rs.getString("image1_url");

				room = new Room(id, title, description, price, countBed, countBath, image1Url);

				list.add(room);
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

	public List<Room> getAllRentedRoomsByLandlordId(int landlordId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `room` where `landlord_id`=? and `status`='rented'");
			ps.setInt(1, landlordId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int countBed = rs.getInt("count_bed");
				int countBath = rs.getInt("count_bath");
				String image1Url = rs.getString("image1_url");

				room = new Room(id, title, description, price, countBed, countBath, image1Url);

				list.add(room);
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

	public Room getAvailableRoomDetails(int roomId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `room` where id =?");
			ps.setInt(1, roomId);
			rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int bond = rs.getInt("bond");
				int squareArea = rs.getInt("square_area");
				int capacity = rs.getInt("capacity");
				int countBed = rs.getInt("count_bed");
				int countBath = rs.getInt("count_bath");
				String availableDate = rs.getString("available_date");
				int landlordId = rs.getInt("landlord_id");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
				String address = rs.getString("address");
				String state = rs.getString("state");
				String postcode = rs.getString("postcode");
				String image1Url = rs.getString("image1_url");
				String image2Url = rs.getString("image2_url");
				String image3Url = rs.getString("image3_url");
				String image4Url = rs.getString("image4_url");
				String mapUrl = rs.getString("map_url");
				String status = rs.getString("status");

				room = new Room(id, title, description, price, bond, squareArea, capacity, countBed, countBath,
						availableDate, landlordId, lat, lng, address, state, postcode, image1Url, image2Url, image3Url,
						image4Url, mapUrl, status);
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

		return room;

	}

	public Room getRentedRoomDetails(int roomId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `room` where id =?");
			ps.setInt(1, roomId);
			rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int bond = rs.getInt("bond");
				int squareArea = rs.getInt("square_area");
				int capacity = rs.getInt("capacity");
				int countBed = rs.getInt("count_bed");
				int countBath = rs.getInt("count_bath");
				String leaseStartDate = rs.getString("lease_start_date");
				int landlordId = rs.getInt("landlord_id");
				int studentId = rs.getInt("student_id");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
				String address = rs.getString("address");
				String state = rs.getString("state");
				String postcode = rs.getString("postcode");
				String image1Url = rs.getString("image1_url");
				String image2Url = rs.getString("image2_url");
				String image3Url = rs.getString("image3_url");
				String image4Url = rs.getString("image4_url");
				String mapUrl = rs.getString("map_url");
				String status = rs.getString("status");

				room = new Room(id, title, description, price, bond, squareArea, capacity, countBed, countBath,
						leaseStartDate, landlordId, studentId, lat, lng, address, state, postcode, image1Url, image2Url,
						image3Url, image4Url, mapUrl, status);

//				System.out.println(room.getLeaseStartDate());

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

		return room;

	}

	public void makeRentedRoomAvaible(int roomId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("UPDATE `room` SET `status` = 'available' WHERE `id` = ?");
			ps.setInt(1, roomId);
			ps.executeUpdate();

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

	}

	public void makeAvaibleRoomOccupied(int roomId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("UPDATE `room` SET `status` = 'rented' WHERE `id` = ?");
			ps.setInt(1, roomId);
			ps.executeUpdate();

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

	}

}
