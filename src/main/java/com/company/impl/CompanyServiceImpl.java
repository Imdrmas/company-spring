package com.company.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.CompanyDao;
import com.company.dao.UserDao;
import com.company.modal.Company;
import com.company.modal.User;
import com.company.service.CompanyService;

@Transactional
@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Company addCompany(Company company, long id) {
		User user = userDao.findById(id).orElse(null);
		company.setCreateAt(new Date());
		user.addCompany(company);
		return companyDao.save(company);
	}

	@Override
	public Company editCompany(Company company, long id) {
		Company existCompany = companyDao.findById(id).get();
		existCompany.setName(company.getName());
		existCompany.setDescription(company.getDescription());
		existCompany.setLocation(company.getLocation());
		return companyDao.save(existCompany);
	}

	@Override
	public Company findCompany(long id) {
		return companyDao.findById(id).get();
	}

	@Override
	public void deleteCompany(long id) {
		companyDao.deleteById(id);
	}

	@Override
	public List<Company> findCompanies() {
		return companyDao.findAll();
	}

}
