package com.company.service;

import com.company.modal.WorkOn;

public interface WorkOnService {

	WorkOn addWorkOn(WorkOn workOn, long id);
	
	WorkOn doneWorkOn(long id, long idProject);
}
