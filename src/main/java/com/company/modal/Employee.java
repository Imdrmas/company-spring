package com.company.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String address;
	
	private double salarty;
	
	private String hiringDate;
	
	private String birthDate;
	
	@ManyToOne
	@JsonBackReference("department")
	private Department department;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<EmployeePhone> employeePhones;
	
	@OneToMany(mappedBy = "employee")
	private List<Project> projects;

	public Employee() {
		super();
	}

	public Employee(String name, String address, double salarty, String hiringDate, String birthDate,
			Department department, List<EmployeePhone> employeePhones, List<Project> projects) {
		super();
		this.name = name;
		this.address = address;
		this.salarty = salarty;
		this.hiringDate = hiringDate;
		this.birthDate = birthDate;
		this.department = department;
		this.employeePhones = employeePhones;
		this.projects = projects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalarty() {
		return salarty;
	}

	public void setSalarty(double salarty) {
		this.salarty = salarty;
	}

	public String getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(String hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<EmployeePhone> getEmployeePhones() {
		return employeePhones;
	}

	public void setEmployeePhones(List<EmployeePhone> employeePhones) {
		this.employeePhones = employeePhones;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void addEmployeePhone(EmployeePhone employeePhone) {
		if (getEmployeePhones()==null) {
			this.employeePhones = new ArrayList<>();
		}
		getEmployeePhones().add(employeePhone);
		employeePhone.setEmployee(this);
	}
	
	public void addProjectToEmploye(Project project) {
		if (getProjects()==null) {
			this.projects = new ArrayList<>();
		}
		getProjects().add(project);
		project.setEmployee(this);
	}

}
