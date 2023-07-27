package coding.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import coding.db.DBUtil;
import coding.entity.Room;
import coding.db.MyConstant;

public class RoomService {

	public List<Room> getThreeRooms() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `room` where `status` = 'available' limit 3");
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

	public List<Room> getAllRooms() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `room` where `status` = 'available'");
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

	public Room getRoomDetails(int roomId) throws SQLException {
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

				room = new Room(id, title, description, price, bond, squareArea, capacity, countBed, countBath,
						availableDate, landlordId, lat, lng, address, state, postcode, image1Url, image2Url, image3Url,
						image4Url, mapUrl);

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

	public List<Room> getRoomsBySearchWithState(String searchInput, String weeklyPrice, String state,
			Date availableDate) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement(
					"SELECT * FROM room \n" + "WHERE ((MATCH (title, description, address, state) AGAINST (?) \n"
							+ "OR available_date >= ?) \n" + "AND price <= ? )\n" + "AND state = ?;");
			ps.setString(1, searchInput);
			ps.setDate(2, availableDate);
			ps.setString(3, weeklyPrice);
			ps.setString(4, state);

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
		System.out.println("List with state: " + list);

		return list;
	}

	public List<Room> getRoomsBySearchWithoutWeeklyPrice(String searchInput, String state, Date availableDate)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement(
					"SELECT * FROM room \n" + "WHERE (MATCH (title, description, address, state) AGAINST (?) \n"
							+ "OR available_date >= ?) \n" + "AND state = ?;");
			ps.setString(1, searchInput);
			ps.setDate(2, availableDate);
			ps.setString(3, state);

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
		System.out.println("List without price: " + list);

		return list;
	}

	public int getTotalPage() throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
//				make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select count(*) as total_room from `room` where `status` = 'available' ");
			rs = ps.executeQuery();

			if (rs.next()) {
				int totalRoom = rs.getInt("total_room");
				return (int) Math.ceil((double) totalRoom / MyConstant.NUMBER_OF_ROOM_IN_ONE_PAGE);
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
		return 0;
	}

	public List<Room> getRoomsByPage(int page) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		try {
//				make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("SELECT * FROM room LIMIT ?, ?");
			ps.setInt(1, (page - 1) * MyConstant.NUMBER_OF_ROOM_IN_ONE_PAGE);
			ps.setInt(2, MyConstant.NUMBER_OF_ROOM_IN_ONE_PAGE);

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
}
