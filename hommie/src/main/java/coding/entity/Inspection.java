package coding.entity;

import java.sql.Timestamp;

public class Inspection {
	private int id;
	private int studentId;
	private int roomId;
	private String enquiryType;
	private Timestamp requestTime;
	private String message;
	private String studentFirstName; 
	private String studentLastName;
	private String studentPhoneNumber;
	private String studentEmail;

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

	
	
	public Inspection(int id, int studentId, int roomId, String enquiryType, Timestamp requestTime, String message,
			String studentFirstName, String studentLastName, String studentPhoneNumber, String studentEmail) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.roomId = roomId;
		this.enquiryType = enquiryType;
		this.requestTime = requestTime;
		this.message = message;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentPhoneNumber = studentPhoneNumber;
		this.studentEmail = studentEmail;
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

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentPhoneNumber() {
		return studentPhoneNumber;
	}

	public void setStudentPhoneNumber(String studentPhoneNumber) {
		this.studentPhoneNumber = studentPhoneNumber;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

}
