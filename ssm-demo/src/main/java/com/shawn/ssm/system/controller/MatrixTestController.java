/**
 * Project Name:ssm-demo
 * File Name:MatrixTestController.java
 * Package Name:com.shawn.ssm.system.controller
 * Date:2016年10月20日下午11:28:44
 * Copyright (c) 2016, China Link Communications LTD All Rights Reserved.
 *
 */

package com.shawn.ssm.system.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: MatrixTestController <br/>
 * Date: 2016年10月20日 下午11:28:44 <br/>
 * Description: TODO
 *
 * @author shawn
 * @version
 * @see
 */
@Controller
@RequestMapping("/matrixtest")
public class MatrixTestController {
	
	// GET /m1/owners/42;q=11;r=12/pets/21;q=22;s=23 (官方示例有问题，此处无法找到)
	// GET /m1/owners/q=11,12/pets/21;q=22;s=23 
	// (output matrixVars:{q=[11, 12, 22], s=[23]} petMatrixVars:{q=[22], s=[23]})
	// 注意：如果/owners/***/pets/21;q=22;s=23中，***部分如果出现;（分号）就会找不到方法
	@RequestMapping(value = "/m1/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String findPet(@MatrixVariable Map<String, String> matrixVars,
			@MatrixVariable(pathVar = "petId") Map<String, String> petMatrixVars) {
		System.out.println(matrixVars+":matrixVars");
		System.out.println(petMatrixVars+":petMatrixVars");
		return "user_list";
	}

	// GET /pets/42;q=11;r=22 (output petId:42 q:11)
	// GET /pets/q=11 (output petId:q=11 q:11)
	@RequestMapping(value = "/m2/pets/{petId}", method = RequestMethod.GET)
	public String findPet2(@PathVariable String petId, @MatrixVariable int q) {
		System.out.println("petId:"+petId);
		System.out.println("q:"+q);
		return "user_list";
	}
	
	// GET /m3/owners/42;q=11/pets/21;q=22 （此处官方示例有点问题，这个路径无法找到方法）
	// GET /m3/owners/q=4/pets/q=21	
	@RequestMapping(value = "/m3/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String findPet3(@MatrixVariable(value = "q", pathVar = "ownerId") int q1,
			@MatrixVariable(value = "q", pathVar = "petId") int q2) {
		System.out.println("q1:"+q1); // q1:4
		System.out.println("q2:"+q2); // q2:21
		return "user_list";
	}
}
