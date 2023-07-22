package coding.entity;

import java.sql.Timestamp;

public class Inspection {
	private int id;
	private int studentId;
	private int roomId;
	private String enquiryType;
	private Timestamp requestTime;
	private String message;

	public Inspection() {

	}

	public Inspection(int id, int studentId, int roomId, String enquiryType, Timestamp requestTime, String message) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.roomId = roomId;
		this.enquiryType = enquiryType;
		this.requestTime = requestTime;
		this.message = message;
	}

	public Inspection(int studentId, int roomId, String enquiryType, String message) {
		super();
		this.studentId = studentId;
		this.roomId = roomId;
		this.enquiryType = enquiryType;
		this.message = message;
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

	public String getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	public Timestamp getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
