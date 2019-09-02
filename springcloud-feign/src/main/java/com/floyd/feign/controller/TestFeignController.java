package com.floyd.feign.controller;

import com.floyd.feign.domian.UserDto;
import com.floyd.feign.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注释
 *
 * @author floyd
 * @version : TestFeignController.java, v 0.1 2019/9/2 9:47 By floyd Edit  $$
 */

@RestController
public class TestFeignController {

	@Autowired(required = false)
	TestService  service;
	
	@RequestMapping ("/feign_test")
	String  feignTest () {
		return service.test ();
	}

	
	
	@RequestMapping ("/feign_test/{mark}")
	String  feignTest2( @PathVariable("mark") int mark){
		String msg = null;
		switch (mark){
			case 1:
				msg = service.test ("qqq");
				break;
			case 2:
				UserDto u = service.test ("qqq", 18);
				msg = u.toString ();
				break;
				
			case 3:
				UserDto user = new UserDto ("www",19);
				msg = service.test (user);
					break;
			default:
				msg = "this mark value invalid!";
				break;
		}
		
		return  msg;
	}
	
}
