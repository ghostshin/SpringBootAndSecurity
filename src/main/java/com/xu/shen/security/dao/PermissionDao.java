package com.xu.shen.security.dao;

import java.util.List;

import com.xu.shen.security.enity.Permission;

public interface PermissionDao {
	/**
	 * 根据用户ID获取资源权限列表
	 * 
	 * @param sUserId
	 * @return
	 */

	public List<Permission> findSPermissionListBySUserId(int userId);

	/**
	 * 根据资源路径获取资源权限列表
	 * 
	 * @param sPermissionUrl
	 * @return
	 */
	public List<Permission> findSPermissionListBySPermissionUrl(String permissionUrl);

}
