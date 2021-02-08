package com.company.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.ProjectDao;
import com.company.dao.WorkOnDao;
import com.company.modal.Process;
import com.company.modal.Project;
import com.company.modal.WorkOn;
import com.company.service.WorkOnService;

@Transactional
@Component
public class WorkOnServiceImpl implements WorkOnService {
	
	@Autowired
	private WorkOnDao workOnDao;
	
	@Autowired
	private ProjectDao projectDao;

	@Override
	public WorkOn addWorkOn(WorkOn workOn, long id) {
		Project project = projectDao.findById(id).get();
		project.addWorkOn(workOn);
		return workOnDao.save(workOn);
	}

	@Override
	public WorkOn doneWorkOn(long id, long idProject) {
		Project project = projectDao.findById(idProject).get();
		WorkOn workOn = workOnDao.findById(id).get();
		if (project.getProcess()==Process.DONE) {
			workOn.setDone(true);
		}
		return workOnDao.save(workOn);
	}
	

}
