/**
 * Project Name:ssm-demo
 * File Name:User.java
 * Package Name:com.shawn.ssm.system.domain
 * Date:2016年10月15日下午6:29:58
 * Copyright (c) 2016, China Link Communications LTD All Rights Reserved.
 *
 */


package com.shawn.ssm.system.domain;

import java.sql.Timestamp;

/**
 * ClassName: User <br/>
 * Date: 2016年10月15日 下午6:29:58 <br/>
 * Description: TODO 
 *
 * @author shawn
 * @version 
 * @see
 */
public class User {
	private Long id;
	private String username;
	private String password;
	private Timestamp birthday;
	
	public User(){
		
	}
	public User(Long id,String username, String password, Timestamp birthday) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday + "]";
	}
	
}

