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
import com.company.modal.EmployeePhone;
import com.company.service.EmployeePhoneService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class EmployeePhoneController {
	
	@Autowired
	private EmployeePhoneService employeePhoneService;
	
	@PostMapping("/addEmployeePhone/{id}")
	EmployeePhone addEmployeePhone(@RequestBody EmployeePhone employeePhone, @PathVariable long id) {
		return employeePhoneService.addEmployeePhone(employeePhone, id);
	}
	
	@PutMapping("/editEmployeePhone/{id}")
	EmployeePhone editEmployeePhone(@RequestBody EmployeePhone employeePhone, @PathVariable long id) {
		return employeePhoneService.editEmployeePhone(employeePhone, id);
	}
	
	@DeleteMapping("/deleteEmployeePhone/{id}")
	void deleteEmployeePhone(@PathVariable long id) {
		employeePhoneService.deleteEmployeePhone(id);
	}
	@GetMapping("/findEmployeePhones/{id}")
	List<EmployeePhone> findEmployeePhones(@PathVariable long id) {
		return employeePhoneService.findEmployeePhones(id);
	}
	
	@GetMapping("/findEmployeePhone/{id}")
	EmployeePhone findEmployeePhone(@PathVariable long id) {
		return employeePhoneService.findEmployeePhone(id);
	}

}
