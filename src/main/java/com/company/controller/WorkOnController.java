package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.modal.WorkOn;
import com.company.service.WorkOnService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class WorkOnController {
	
	@Autowired
	private WorkOnService workOnService;
	
	@PostMapping("/addWorkOn/{id}")
	WorkOn addWorkOn(WorkOn workOn, long id) {
		return workOnService.addWorkOn(workOn, id);
	}
	
	@PutMapping("/doneWorkOn/{id}/{idProject}")
	WorkOn doneWorkOn(long id, long idProject) {
		return workOnService.doneWorkOn(id, idProject);
	}
	

}
