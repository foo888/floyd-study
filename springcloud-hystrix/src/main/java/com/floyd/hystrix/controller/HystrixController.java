package com.floyd.hystrix.controller;

import com.floyd.hystrix.service.HystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注释
 *
 * @author floyd
 * @version : HystrixController.java, v 0.1 2019/8/30 14:37 By floyd Edit  $$
 */

@RestController
public class HystrixController {
	
	private final Logger logger = LoggerFactory.getLogger (HystrixController.class);
	
	@Autowired
	HystrixService  service;
	
	@RequestMapping("/test")
	String  index (){
		String result = service.getServer ();
		logger.info ("响应{}",result);
		return result;
	}
	
}
