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

import com.company.modal.Company;
import com.company.service.CompanyService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/addCompany/{id}")
	Company addCompany(@RequestBody Company company, @PathVariable long id) {
		return companyService.addCompany(company, id);
	}
	
	@PutMapping("/editCompany/{id}")
	Company editCompany(@RequestBody Company company, @PathVariable long id) {
		return companyService.editCompany(company, id);
	}
	
	@GetMapping("/findCompany/{id}")
	Company findCompany(@PathVariable long id) {
		return companyService.findCompany(id);
	}
	
	@DeleteMapping("/deleteCompany/{id}")
	void deleteCompany(@PathVariable long id) {
		companyService.deleteCompany(id);
	}
	
	@GetMapping("/findCompanies")
	List<Company> findCompaniesForUser() {
		return companyService.findCompanies();
	}
}
