package com.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.UserDao;
import com.company.modal.User;
import com.company.service.UserService;

@Transactional
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		List<User> users = userDao.findAll();
		if (users.size() == 0) {
			user.setAdmin(true);
		}
		for (User existUser : users) {
			if (user.getUsername().equals(existUser.getUsername())) {
				existUser.setUsername(existUser.getUsername());
				existUser.setPassword(existUser.getPassword());
				return userDao.save(existUser);
			}
		}

		return userDao.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User editUser(User user, long id) {
		User existUser = userDao.findById(id).get();
		existUser.setUsername(user.getUsername());
		existUser.setPassword(user.getPassword());
		return userDao.save(existUser);
	}

	@Override
	public User findUserById(long id) {
		return userDao.findById(id).get();
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> users = userDao.findByUsername(username);
		if (users.isPresent()) {
			User user = users.get();
			return user;
		}
		return null;
	}
}
