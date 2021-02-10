package com.company.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.DepartmentDao;
import com.company.dao.EmployeeDao;
import com.company.dao.ProjectDao;
import com.company.modal.Department;
import com.company.modal.Employee;
import com.company.modal.Project;
import com.company.service.ProjectService;

@Transactional
@Component
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Project addProjectToEmployee(long idEmployee, long idProject) {
		Employee employee = employeeDao.findById(idEmployee).get();
		Project project = projectDao.findById(idProject).get();
		employee.addProjectToEmploye(project);
		return projectDao.save(project);
	}

	@Override
	public Project addProjectToDeprtment(Project project, long id) {
		Department department = departmentDao.findById(id).get();
		project.setCreateAt(new Date());
		department.addProjectToDepratment(project);
		return projectDao.save(project);
	}

	@Override
	public Project editProject(Project project, long id) {
		Project existProject = projectDao.findById(id).get();
		existProject.setName(project.getName());
		existProject.setDescription(project.getDescription());
        existProject.setProcess(project.getProcess());
		return projectDao.save(existProject);
	}

	@Override
	public Project findProject(long id) {
		return projectDao.findById(id).get();
	}

	@Override
	public void deleteProejct(long id) {
		Project project = projectDao.findById(id).get();
		projectDao.delete(project);
	}

	@Override
	public List<Project> findProjectsForEmplopyee(long id) {
		Employee employee = employeeDao.findById(id).get();
		return employee.getProjects();
	}

	@Override
	public List<Project> findProjects() {
		return projectDao.findAll();
	}

	@Override
	public void deleteProjectFromEmployee(long idEmployee, long idProject) {
		Employee employee = employeeDao.findById(idEmployee).get();
		Project project = projectDao.findById(idProject).get();
		employee.getProjects().remove(project);
		
	}

}
