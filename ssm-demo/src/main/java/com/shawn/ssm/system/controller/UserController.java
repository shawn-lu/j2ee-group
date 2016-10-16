/**
 * Project Name:ssm-demo
 * File Name:UserController.java
 * Package Name:com.shawn.ssm.system.controller
 * Date:2016年10月16日下午10:51:53
 * Copyright (c) 2016, China Link Communications LTD All Rights Reserved.
 *
 */


package com.shawn.ssm.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: UserController <br/>
 * Date: 2016年10月16日 下午10:51:53 <br/>
 * Description: TODO 
 *
 * @author shawn
 * @version 
 * @see
 */
@Controller
@RequestMapping("/system")
public class UserController {
	
    @RequestMapping(value = "/user.do", params = { "method=showList" })
	public String show(){
		return "user_list";
	}
}

