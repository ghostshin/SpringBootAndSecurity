package com.xu.shen.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xu.shen.security.dao.PermissionDao;
import com.xu.shen.security.dao.RoleDao;
import com.xu.shen.security.dao.UserDao;
import com.xu.shen.security.enity.Permission;
import com.xu.shen.security.enity.Role;
import com.xu.shen.security.enity.User;

@Service
public class SecurityDataServiceImpl {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;

	public User findSUserByName(String name) {
		return userDao.findSUserByName(name);
	}

	public List<Role> findSRoleListBySUserId(int sUserId) {
		return roleDao.findSRoleListBySUserId(sUserId);
	}

	public List<Role> findSRoleListBySPermissionUrl(String sPermissionUrl) {
		return roleDao.findSRoleListBySPermissionUrl(sPermissionUrl);
	}

	public List<Permission> findSPermissionListBySUserId(int sUserId) {
		return permissionDao.findSPermissionListBySUserId(sUserId);
	}

	public List<Permission> findSPermissionListBySPermissionUrl(String sPermissionUrl) {
		return permissionDao.findSPermissionListBySPermissionUrl(sPermissionUrl);
	}
}
