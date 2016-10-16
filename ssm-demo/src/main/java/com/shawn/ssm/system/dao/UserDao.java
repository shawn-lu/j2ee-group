/**
 * Project Name:ssm-demo
 * File Name:UserDao.java
 * Package Name:com.shawn.ssm.system.dao
 * Date:2016年10月3日下午3:18:04
 *
 */


package com.shawn.ssm.system.dao;

import java.util.List;

import com.shawn.ssm.system.domain.User;

/**
 * ClassName: UserDao <br/>
 * Date: 2016年10月3日 下午3:18:04 <br/>
 * Description: TODO 
 *
 * @author lxf
 * @version 
 * @see
 */
public interface UserDao {
	public List<User> selectUsers();
	
	public void insertUser(User user); 
}

