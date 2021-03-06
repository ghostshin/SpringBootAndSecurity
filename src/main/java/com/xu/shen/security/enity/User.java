package com.xu.shen.security.enity;

public class User {
	private int id;
	private String name;
	private String password;

	public User(User user) {
		this.id = user.getId();  
        this.name = user.getName();  
        this.password = user.getPassword(); 
	}
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
