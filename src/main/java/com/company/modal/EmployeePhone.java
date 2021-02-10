package com.company.modal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EmployeePhone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String phone;
	
	@ManyToOne
	@JsonBackReference(value = "employee")
	private Employee employee;

	public EmployeePhone() {
		super();
	}

	public EmployeePhone(String phone, Employee employee) {
		super();
		this.phone = phone;
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
