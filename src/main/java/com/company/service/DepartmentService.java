package com.company.service;

import java.util.List;

import com.company.modal.Department;

public interface DepartmentService {
	
	Department addDepartment(Department department, long id);
	
	Department editDepartment(Department department, long id);
	
	Department findDepartment(long id);
	
	void deleteDepartment(long id);

}
