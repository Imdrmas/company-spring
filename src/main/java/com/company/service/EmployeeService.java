package com.company.service;

import java.util.List;

import com.company.modal.Employee;

public interface EmployeeService {
	
	 Employee addEmployee(Employee employee, long id);
	 
	 Employee editEmployee(Employee employee, long id);
	 
	 Employee findEmployee(long id);
	 
	 void deleteEmployee(long id);
	 
	 List<Employee> findEmployees();

}
