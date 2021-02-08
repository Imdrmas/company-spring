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

import com.company.modal.Project;
import com.company.service.ProjectService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/addProjectToEmploye/{idEmployee}/{idProject}")
	 void addProjectToEmploye(@PathVariable long idEmployee, @PathVariable long idProject) {
		 projectService.addProjectToEmploye(idEmployee, idProject);;
	 }
	 @PostMapping("/addProjectToDeprtment/{id}")
	 Project addProjectToDeprtment(@RequestBody Project project, @PathVariable long id) {
		 return projectService.addProjectToDeprtment(project, id);
	 }
	 @PutMapping("/editProject/{id}")
	 Project editProject(@RequestBody Project project, @PathVariable long id) {
		 return projectService.editProject(project, id);
	 }
	 @GetMapping("/findProject/{id}")
	 Project findProject(@PathVariable long id) {
		 return projectService.findProject(id);
	 }
	 @DeleteMapping("/deleteProejct/{id}")
	 void deleteProejct(@PathVariable long id) {
		 projectService.deleteProejct(id);
	 }
	 @GetMapping("/findProjectsForEmplopyee/{id}")
	 List<Project> findProjectsForEmplopyee(@PathVariable long id) {
		 return findProjectsForEmplopyee(id);
	 }
	 
	 @GetMapping("/findProjectsForDepratment/{id}")
	 List<Project> findProjectsForDepratment(@PathVariable long id) {
		 return projectService.findProjectsForDepratment(id);
	 }
}
