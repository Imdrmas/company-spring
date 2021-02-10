package com.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.DepartmentDao;
import com.company.dao.EmployeeDao;
import com.company.modal.Department;
import com.company.modal.Employee;
import com.company.service.EmployeeService;

@Transactional
@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Employee addEmployee(Employee employee, long id) {
		Department department = departmentDao.findById(id).get();
		department.addEmployee(employee);
		return employeeDao.save(employee);
	}

	@Override
	public Employee editEmployee(Employee employee, long id) {
		Employee existEmployee = employeeDao.findById(id).get();
		existEmployee.setName(employee.getName());
		existEmployee.setAddress(employee.getAddress());
		existEmployee.setSalary(employee.getSalary());
		existEmployee.setBirthDate(employee.getBirthDate());
		existEmployee.setHiringDate(employee.getHiringDate());
		return employeeDao.save(existEmployee);
	}

	@Override
	public Employee findEmployee(long id) {
		return employeeDao.findById(id).get();
	}

	@Override
	public void deleteEmployee(long id) {
		employeeDao.deleteById(id);
	}

	@Override
	public List<Employee> findEmployees() {
		return employeeDao.findAll();
	}


}
