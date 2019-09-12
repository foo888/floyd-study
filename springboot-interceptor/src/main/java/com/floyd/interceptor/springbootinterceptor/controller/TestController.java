package com.floyd.interceptor.springbootinterceptor.controller;

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
	
	@RequestMapping ("/")
	@ResponseBody
	String  index (){
		return "hello";
	}
	
	@RequestMapping ("/test")
	String test () {
		return "index";
	}
	
}
