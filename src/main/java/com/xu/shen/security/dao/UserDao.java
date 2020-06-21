package com.xu.shen.security.dao;

import com.xu.shen.security.enity.User;

public interface UserDao {
	/**
	 * 根据用户名获取用户
	 * 
	 * @param name
	 * @return
	 */
	public User findSUserByName(String name);

	public int setNewUser(User user);
}
