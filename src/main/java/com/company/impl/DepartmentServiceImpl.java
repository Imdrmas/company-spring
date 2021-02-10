package com.company.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.CompanyDao;
import com.company.dao.DepartmentDao;
import com.company.modal.Company;
import com.company.modal.Department;
import com.company.service.DepartmentService;

@Transactional
@Component
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	public Department addDepartment(Department department, long id) {
		Company company = companyDao.findById(id).get();
		department.setCreateAt(new Date());
		company.addDepartment(department);
		return departmentDao.save(department);
	}

	@Override
	public Department editDepartment(Department department, long id) {
		Department existDepartment = departmentDao.findById(id).get();
		existDepartment.setCode(department.getCode());
		existDepartment.setLocation(department.getLocation());
		existDepartment.setDescription(department.getDescription());
		return departmentDao.save(existDepartment);
	}

	@Override
	public Department findDepartment(long id) {
		return departmentDao.findById(id).get();
	}

	@Override
	public void deleteDepartment(long id) {
		departmentDao.deleteById(id);
	}

}
