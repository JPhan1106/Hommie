package coding.entity;

import java.sql.Timestamp;

public class Payment {
	private int id;
	private int landlordId;
	private int roomId;
	private double listingFee;
	private Timestamp listingDate;
	
	public Payment() {
		
	}

	public Payment(int id, int landlordId, int roomId, double listingFee, Timestamp listingDate) {
		super();
		this.id = id;
		this.landlordId = landlordId;
		this.roomId = roomId;
		this.listingFee = listingFee;
		this.listingDate = listingDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getListingFee() {
		return listingFee;
	}

	public void setListingFee(double listingFee) {
		this.listingFee = listingFee;
	}

	public Timestamp getListingDate() {
		return listingDate;
	}

	public void setListingDate(Timestamp listingDate) {
		this.listingDate = listingDate;
	}
	
}
