package com.company.modal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class WorkOn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private boolean done;
    
    @ManyToOne
    @JsonBackReference("project")
    private Project project;

	public WorkOn() {
		super();
	}

	public WorkOn(long id, boolean done, Project project) {
		super();
		this.id = id;
		this.done = done;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
     
     
}
