package com.xu.shen.security.service;

import org.springframework.stereotype.Service;

import com.xu.shen.security.enity.User;


public interface UserService {
	public User findSUserByName(String name);

	public int setNewUser(User user);
}
