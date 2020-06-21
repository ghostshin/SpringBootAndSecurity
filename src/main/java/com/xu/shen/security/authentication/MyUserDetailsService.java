package com.xu.shen.security.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xu.shen.security.enity.Permission;
import com.xu.shen.security.enity.Role;
import com.xu.shen.security.enity.User;
import com.xu.shen.security.service.SecurityDataServiceImpl;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	SecurityDataServiceImpl securityDataService;
	
	

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		User sUser = securityDataService.findSUserByName(username);
		// 加入异常判断，防止找不到用户名的时候出问题
		if (sUser == null) {
			return null;
		}

		// 用户角色列表
		List<Role> sRoleList = securityDataService.findSRoleListBySUserId(sUser.getId());
		// 用户资源权限列表
		List<Permission> sPermissionList = securityDataService.findSPermissionListBySUserId(sUser.getId());

		return new MyUserDetails(sUser, sRoleList, sPermissionList);
	}
}
