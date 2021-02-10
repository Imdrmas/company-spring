package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.modal.Department;
import com.company.service.DepartmentService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/addDepartment/{id}")
	Department addDepartment(@RequestBody Department department, @PathVariable long id) {
		return departmentService.addDepartment(department, id);
	}
	
	@PutMapping("/editDepartment/{id}")
	Department editDepartment(@RequestBody Department department, @PathVariable long id) {
		return departmentService.editDepartment(department, id);
	}
	
	@GetMapping("/findDepartment/{id}")
	Department findDepartment(@PathVariable long id) {
		return departmentService.findDepartment(id);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	void deleteDepartment(@PathVariable long id) {
		departmentService.deleteDepartment(id);
	}


}
