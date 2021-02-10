package com.company.service;

import java.util.List;

import com.company.modal.Project;

public interface ProjectService {
	
 Project addProjectToEmployee(long idEmployee, long idProject);
 
 Project addProjectToDeprtment(Project project, long id);
 
 Project editProject(Project project, long id);
 
 Project findProject(long id);
 
 void deleteProejct(long id);
 
 List<Project> findProjectsForEmplopyee(long id);

List<Project> findProjects();

void deleteProjectFromEmployee(long idEmployee, long idProject);
 
}
