package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.modal.Company;

@Service
public interface CompanyService {
	
	Company addCompany(Company company, long id);
	
	Company editCompany(Company company, long id);
	
	Company findCompany(long id);
	
	void deleteCompany(long id);
	
	List<Company> findCompanies();

}
