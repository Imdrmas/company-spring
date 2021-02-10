package com.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.EmployeeDao;
import com.company.dao.EmployeePhoneDao;
import com.company.modal.Employee;
import com.company.modal.EmployeePhone;
import com.company.service.EmployeePhoneService;

@Transactional
@Component
public class EmployeePhoneServiceImpl implements EmployeePhoneService {
	
	@Autowired
	private EmployeePhoneDao employeePhoneDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeePhone addEmployeePhone(EmployeePhone employeePhone, long id) {
		Employee employee = employeeDao.findById(id).get();
		employee.addEmployeePhone(employeePhone);
		return employeePhoneDao.save(employeePhone);
	}

	@Override
	public EmployeePhone editEmployeePhone(EmployeePhone employeePhone, long id) {
		EmployeePhone exsitEmployeePhone = employeePhoneDao.findById(id).get();
		exsitEmployeePhone.setPhone(employeePhone.getPhone());
		return employeePhoneDao.save(exsitEmployeePhone);
	}

	@Override
	public void deleteEmployeePhone(long id) {
		employeePhoneDao.deleteById(id);
	}

	@Override
	public List<EmployeePhone> findEmployeePhones(long id) {
		Employee employee = employeeDao.findById(id).get();
		return employee.getEmployeePhones();
	}

	@Override
	public EmployeePhone findEmployeePhone(long id) {
		return employeePhoneDao.findById(id).get();
	}
	
	

}
