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
	
	@PostMapping("/addProjectToEmployee/{idEmployee}/{idProject}")
	 Project addProjectToEmploye(@PathVariable long idEmployee, @PathVariable long idProject) {
		return projectService.addProjectToEmployee(idEmployee, idProject);
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
		 return projectService.findProjectsForEmplopyee(id);
	 }
	 @GetMapping("/findProjects")
	 List<Project> findProjects() {
		 return projectService.findProjects();
	 }
	 @DeleteMapping("/deleteProjectFromEmployee/{idEmployee}/{idProject}")
	 void deleteProjectFromEmployee(@PathVariable long idEmployee, @PathVariable long idProject) {
		 projectService.deleteProjectFromEmployee(idEmployee, idProject);
	 }
}
