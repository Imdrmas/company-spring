package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.modal.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long>{

}
