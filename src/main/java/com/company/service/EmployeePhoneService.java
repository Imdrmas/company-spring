package com.company.service;

import com.company.modal.EmployeePhone;

public interface EmployeePhoneService {
	
	EmployeePhone addEmployeePhone(EmployeePhone employeePhone, long id);
	
	EmployeePhone editEmployeePhone(EmployeePhone employeePhone, long id);
	
	void deleteEmployeePhone(long id);

}
