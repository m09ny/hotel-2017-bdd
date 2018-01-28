package bdd.mongo.models;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Accomodation {
	
	@Id
	private String id;
	private String idEmployee;
	private String idBill;
	private String idRoom;
	private String arrivalDate;
	private int noOfNights;
	
	public Accomodation() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getIdBill() {
		return idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getNoOfNights() {
		return noOfNights;
	}

	public void setNoOfNights(int noOfNights) {
		this.noOfNights = noOfNights;
	}

	@Override
	public String toString() {
		return "Accomodation [id=" + id + ", idEmployee=" + idEmployee + ", idBill=" + idBill + ", idRoom=" + idRoom
				+ ", arrivalDate=" + arrivalDate + ", noOfNights=" + noOfNights + "]";
	}


}