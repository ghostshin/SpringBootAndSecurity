package com.xu.shen.security.authentication;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.xu.shen.security.enity.Permission;
import com.xu.shen.security.enity.Role;
import com.xu.shen.security.enity.User;

/**
 * @author xlelo ！认证！----自定义userDetails
 */
public class MyUserDetails extends User implements UserDetails {

	// 用户角色列表
	private List<Role> sRoleList = null;
	// 用户资源权限列表
	private List<Permission> sPermissionList = null;

	public MyUserDetails(User user, List<Role> sRoleList, List<Permission> sPermissionList) {
		 	super(user);  
	        this.sRoleList = sRoleList;  
	        this.sPermissionList = sPermissionList;  
		

	}

	public List<Role> getsRoleList() {
		return sRoleList;
	}

	public void setsRoleList(List<Role> sRoleList) {
		this.sRoleList = sRoleList;
	}

	public List<Permission> getsPermissionList() {
		return sPermissionList;
	}

	public void setsPermissionList(List<Permission> sPermissionList) {
		this.sPermissionList = sPermissionList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub

		StringBuilder authoritiesBuilder = new StringBuilder("");

		List<Role> tempRoleList = this.getsRoleList();
		if (null != tempRoleList) {
			for (Role role : tempRoleList) {
				authoritiesBuilder.append(",").append(role.getRole());
			}
		}
		List<Permission> tempPermissionList = this.getsPermissionList();
		if (null != tempPermissionList) {
			for (Permission permission : tempPermissionList) {
				authoritiesBuilder.append(",").append(permission.getPermission());
			}
		}
		
		String authoritiesStr = "";  
        if(authoritiesBuilder.length()>0) {  
            authoritiesStr = authoritiesBuilder.deleteCharAt(0).toString();  
        } 
        
       return AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesStr);  
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getName();  
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;  
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;  
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		 return true;  
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		 return true;  
	}

	@Override
	public int hashCode() {
		return this.getUsername().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	@Override
	public String toString() {
		return this.getUsername();
	}
	
	
	
}
