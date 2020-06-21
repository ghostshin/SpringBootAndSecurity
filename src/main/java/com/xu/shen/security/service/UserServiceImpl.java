package com.xu.shen.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xu.shen.security.dao.UserDao;
import com.xu.shen.security.enity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired

	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder; // security提供的加密接口，写在WebSecurityConfig里面

	@Override
	public User findSUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setNewUser(User user) {
		// TODO Auto-generated method stub

		// 开始搞事情，主要就是对password加密。

		if (user.getName() != null && user.getPassword() != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}

		int a = userDao.setNewUser(user);

		return a;
	}

}
