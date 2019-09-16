package com.floyd.interceptor.springbootinterceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注释
 *
 * @author floyd
 * @version : TestController.java, v 0.1 2019/9/12 13:50 By floyd Edit  $$
 */

@Controller
public class TestController {
	
	private final Logger  logger = LoggerFactory.getLogger (TestController.class);
	
	@RequestMapping ("/")
	@ResponseBody
	String  index (){
		logger.info ("controller 逻辑处理。。。");
		return "hello";
	}
	
	@RequestMapping ("/test")
	String test () {
		logger.info ("controller 逻辑处理。。。");
		return "index";
	}
	
}
