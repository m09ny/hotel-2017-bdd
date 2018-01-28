package bdd.mongo.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	
	@Id
	private String id;
	
	private String name;
	private String email;
	private String address;
	private String role;
	private double salary;
	private String departmentId;

	public Employee() {
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", role=" + role
				+ ", salary=" + salary + ", departmentId=" + departmentId + "]";
	}

}