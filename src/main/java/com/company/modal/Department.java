package com.company.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String code;

	private String location;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@ManyToOne
	@JsonBackReference(value = "company")
	private Company company;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee> employees;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Project> projects;

	public Department() {
		super();
	}

	public Department(String code, String location, String description, Date createAt, Company company,
			List<Employee> employees, List<Project> projects) {
		super();
		this.code = code;
		this.location = location;
		this.description = description;
		this.createAt = createAt;
		this.company = company;
		this.employees = employees;
		this.projects = projects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee employee) {
		if (getEmployees() == null) {
			this.employees = new ArrayList<>();
		}
		getEmployees().add(employee);
		employee.setDepartment(this);
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void addProjectToDepratment(Project project) {
		if (getProjects() == null) {
			this.projects = new ArrayList<>();
		}
		getProjects().add(project);
		project.setDepartment(this);
	}

}
