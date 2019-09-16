package com.floyd.interceptor.springbootinterceptor.controller;

import com.floyd.interceptor.springbootinterceptor.domain.RequestUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api 控制器示例
 *
 * @author floyd
 * @version : APIController.java, v 0.1 2019/9/16 14:35 By floyd Edit  $$
 */

@RequestMapping ("/api")
@RestController
public class APIController {

	
	@GetMapping (value = "/users")
	String  test (RequestUser requestUser){
		return requestUser.toString ();
	}
	
	@GetMapping (value = "/user/{id}")
	String  test ( @PathVariable ("id") int id) {
		return "success inf";
	}

}
