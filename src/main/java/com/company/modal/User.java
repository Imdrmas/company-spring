package com.company.modal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String username;

	private String password;

	private boolean admin;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Company> companies;

	public User() {
		super();
	}

	public User(String username, String password, boolean admin, List<Company> companies) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.companies = companies;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public void addCompany(Company company) {
		if (getCompanies() == null) {
			this.companies = new ArrayList<>();
		}
		getCompanies().add(company);
		company.setUser(this);
	}

}
