package bdd.mongo.models;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String address;

	public Client() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

	
}