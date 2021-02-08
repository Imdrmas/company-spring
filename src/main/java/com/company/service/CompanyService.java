package com.company.service;

import java.util.List;

import com.company.modal.Company;

public interface CompanyService {
	
	Company addCompany(Company company, long id);
	
	Company editCompany(Company company, long id);
	
	Company findCompany(long id);
	
	void deleteCompany(long id);
	
	List<Company> findCompaniesForUser(long id);

}
