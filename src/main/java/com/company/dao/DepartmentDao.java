package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.modal.Department;

public interface DepartmentDao extends JpaRepository<Department, Long>{

}
