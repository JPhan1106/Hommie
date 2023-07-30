package coding.entity;

import java.sql.Timestamp;

public class WishListItem {
	private Room room;
	
	private int id;
	private int studentId;
	private int roomId;
	private Timestamp addedTime;
	
	
	public WishListItem(int id, int studentId, int roomId, Timestamp addedTime) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.roomId = roomId;
		this.addedTime = addedTime;
	}
	
	
	
	public WishListItem(Room room, int studentId) {
		super();
		this.room = room;
		this.studentId = studentId;
	}



	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Timestamp getAddedTime() {
		return addedTime;
	}
	public void setAddedTime(Timestamp addedTime) {
		this.addedTime = addedTime;
	}
	
	

}
