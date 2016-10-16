/**
 * Project Name:ssm-demo
 * File Name:UserDaoImplTest.java
 * Package Name:com.shawn.ssm.system.dao.impl
 * Date:2016年10月15日下午7:03:28
 * Copyright (c) 2016, China Link Communications LTD All Rights Reserved.
 *
 */


package com.shawn.ssm.system.dao.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shawn.ssm.system.dao.UserDao;
import com.shawn.ssm.system.domain.User;

/**
 * ClassName: UserDaoImplTest <br/>
 * Date: 2016年10月15日 下午7:03:28 <br/>
 * Description: TODO 
 *
 * @author shawn
 * @version 
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@ActiveProfiles("dev")
public class UserDaoImplTest {
	@Autowired
	private UserDao userDaoImpl;
	@Test
	public void testSelectUsers(){
		List<User> users = userDaoImpl.selectUsers();
		printCollection(users);
	}
	
	@Test
	public void testInsertUser(){
		User u = new User(5l,"Tommy","123456",new Timestamp(System.currentTimeMillis()));
		userDaoImpl.insertUser(u);
		List<User> users = userDaoImpl.selectUsers();
		printCollection(users);
	}
	
	public static <T> void printCollection(Collection<T> c){
		for(T t:c){
			System.out.println(t);
		}
	}
}

