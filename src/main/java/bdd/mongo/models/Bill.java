package bdd.mongo.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bill {
	
	@Id
	private String id;
	private String idEmployee;
	private String idClient;
	private String date;
	private double amount;

	public Bill() {
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

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", idEmployee=" + idEmployee + ", idClient=" + idClient + ", date=" + date
				+ ", amount=" + amount + "]";
	}

}