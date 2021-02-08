package com.company.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private Process process;
	
	@ManyToOne
	@JsonBackReference("employee")
	private Employee employee;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<WorkOn> workOns;
	
	@ManyToOne
	@JsonBackReference("department")
	private Department department;

	public Project() {
		super();
	}

	public Project(String name, String description, Process process, Employee employee, List<WorkOn> workOns,
			Department department) {
		super();
		this.name = name;
		this.description = description;
		this.process = process;
		this.employee = employee;
		this.workOns = workOns;
		this.department = department;
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<WorkOn> getWorkOns() {
		return workOns;
	}

	public void setWorkOns(List<WorkOn> workOns) {
		this.workOns = workOns;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void addWorkOn(WorkOn workOn) {
		if (getWorkOns()==null) {
			this.workOns = new ArrayList<>();
		}
		getWorkOns().add(workOn);
		workOn.setProject(this);
	}

}
