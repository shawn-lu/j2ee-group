/**
 * Project Name:ssm-demo
 * File Name:UserDaoImpl.java
 * Package Name:com.shawn.ssm.system.dao.impl
 * Date:2016年10月3日下午3:18:48
 *
 */

package com.shawn.ssm.system.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shawn.ssm.system.dao.UserDao;
import com.shawn.ssm.system.domain.User;

/**
 * ClassName: UserDaoImpl <br/>
 * Date: 2016年10月3日 下午3:18:48 <br/>
 * Description: TODO 
 *
 * @author lxf
 * @version 
 * @see
 */
@Repository
public class UserDaoImpl implements UserDao     {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<User> selectUsers(){
		return sqlSession.selectList("selectUsers");
	}

	public void insertUser(User user) {
		sqlSession.insert("insertUser", user);
	}
}

