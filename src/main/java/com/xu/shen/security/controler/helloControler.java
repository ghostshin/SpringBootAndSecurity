package com.xu.shen.security.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xu.shen.security.service.SecurityDataServiceImpl;

@Controller
public class helloControler {

	@RequestMapping("index")
	public String index() {
		return "hello";
	}

	@RequestMapping("/admin")
	public String admin(Model model, String tt) {
		return "admin";
	}

	@RequestMapping("/hello")
	public String hello(Model model, String tt) {
		return "hello";
	}

}
