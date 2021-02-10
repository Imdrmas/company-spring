package com.company.service;

import java.util.List;

import com.company.modal.EmployeePhone;

public interface EmployeePhoneService {
	
	EmployeePhone addEmployeePhone(EmployeePhone employeePhone, long id);
	
	EmployeePhone editEmployeePhone(EmployeePhone employeePhone, long id);
	
	void deleteEmployeePhone(long id);
	
	List<EmployeePhone> findEmployeePhones(long id);
	
	EmployeePhone findEmployeePhone(long id);

}
