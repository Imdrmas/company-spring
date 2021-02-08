package com.company.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.modal.User;

public interface UserDao extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

}
