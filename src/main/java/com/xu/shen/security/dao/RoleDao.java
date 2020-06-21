package com.xu.shen.security.dao;

import java.util.List;

import com.xu.shen.security.enity.Role;

public interface RoleDao {
    /** 
     * 根据用户ID获取角色列表 
     * @param userId 
     * @return 
     */  
	public List<Role> findSRoleListBySUserId(int userId);
	
	public List<Role> findSRoleListBySPermissionUrl(String permissionUrl);
}
