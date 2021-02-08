package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.modal.Project;

public interface ProjectDao extends JpaRepository<Project, Long> {

}
