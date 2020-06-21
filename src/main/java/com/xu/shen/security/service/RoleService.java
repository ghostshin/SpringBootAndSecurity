package com.xu.shen.security.service;

import java.util.List;

import com.xu.shen.security.enity.Role;

public interface RoleService {
	public List<Role> findSRoleListBySUserId(int userId);

	public List<Role> findSRoleListBySPermissionUrl(String permissionUrl);
}
