package com.company.controller;


import java.util.List;

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

import com.company.modal.Employee;
import com.company.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee/{id}")
	 Employee addEmployee(@RequestBody Employee employee, @PathVariable long id) {
		 return employeeService.addEmployee(employee, id);
	 }
	 
	@PutMapping("/editEmployee/{id}")
	 Employee editEmployee(@RequestBody Employee employee, @PathVariable long id) {
		 return employeeService.editEmployee(employee, id);
	 }
	 
	@GetMapping("/findEmployee/{id}")
	 Employee findEmployee(@PathVariable long id) {
		 return employeeService.findEmployee(id);
	 }
	 
	@DeleteMapping("/deleteEmployee/{id}")
	 void deleteEmployee(@PathVariable long id) {
		 employeeService.deleteEmployee(id);
	 }
	@GetMapping("/findEmployees")
	List<Employee> findEmployees() {
		return employeeService.findEmployees();
	}
}
