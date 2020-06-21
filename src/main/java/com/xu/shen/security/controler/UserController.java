package com.xu.shen.security.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xu.shen.security.enity.User;
import com.xu.shen.security.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/doRegister")
	public String register(User user) {
		userService.setNewUser(user);
		return user == null ? "注册失败" : "注册成功";
	}
}
