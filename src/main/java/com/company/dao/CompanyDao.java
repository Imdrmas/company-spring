package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.modal.Company;

public interface CompanyDao extends JpaRepository<Company, Long>{

}
