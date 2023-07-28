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
			ps = conn.prepareStatement("UPDATE `room` SET `status` = 'available' , `student_id` = NULL WHERE `id` = ?");
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
	
	public boolean insertRoom(Room room) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();

//			create sql for insert
			String sql = "INSERT INTO `room`(title, description, price, bond, square_area,capacity, landlord_id, address, state, postcode, count_bed, count_bath, available_date, image1_url, image2_url, image3_url, image4_url, lat, lng) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, room.getTitle());
			ps.setString(2, room.getDescription());
			ps.setInt(3, room.getPrice());
			ps.setInt(4, room.getBond());
			ps.setInt(5, room.getSquareArea());
			ps.setInt(6, room.getCapacity());
			ps.setInt(7, room.getLandlordId());
			ps.setString(8, room.getAddress());
			ps.setString(9, room.getState());
			ps.setString(10, room.getPostcode());
			ps.setInt(11, room.getCountBed());
			ps.setInt(12, room.getCountBath());
			ps.setString(13, room.getAvailableDate());
			ps.setString(14, room.getImage1Url());
			ps.setString(15, room.getImage2Url());
			ps.setString(16, room.getImage3Url());
			ps.setString(17, room.getImage4Url());
			ps.setString(18, room.getLat());
			ps.setString(19, room.getLng());
			ps.executeUpdate();

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

	public void deleteRoom(int roomId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("DELETE FROM `room` WHERE `id` = ?");
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

	public boolean updateRoom(Room room) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("UPDATE `room` SET `title` = ?, `description` = ?, `price` = ?, `bond` = ?, `square_area` = ?, `capacity` = ?, `address` = ?, `state` = ?, `postcode` = ?, `count_bed` = ?, `count_bath` = ?, `available_date` = ? WHERE `id` = ?");
			ps.setString(1, room.getTitle());
			ps.setString(2, room.getDescription());
			ps.setInt(3, room.getPrice());
			ps.setInt(4, room.getBond());
			ps.setInt(5, room.getSquareArea());
			ps.setInt(6, room.getCapacity());
			ps.setString(7, room.getAddress());
			ps.setString(8, room.getState());
			ps.setString(9, room.getPostcode());
			ps.setInt(10, room.getCountBed());
			ps.setInt(11, room.getCountBath());
			ps.setString(12, room.getAvailableDate());
			ps.setInt(13, room.getId());

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
}
