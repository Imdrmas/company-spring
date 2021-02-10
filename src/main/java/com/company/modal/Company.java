package com.company.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String name;

	private String location;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@ManyToOne
	@JsonBackReference(value = "user")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Department> departments;

	public Company() {
		super();
	}

	public Company(String name, String location, String description, Date createAt, User user,
			List<Department> departments) {
		super();
		this.name = name;
		this.location = location;
		this.description = description;
		this.createAt = createAt;
		this.user = user;
		this.departments = departments;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public void addDepartment(Department department) {
		if (getDepartments() == null) {
			this.departments = new ArrayList<>();
		}
		getDepartments().add(department);
		department.setCompany(this);
	}

}
