package com.floyd.eureka.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 注释
 *
 * @author floyd
 * @version : RibbonController.java, v 0.1 2019/8/29 15:56 By floyd Edit  $$
 */
@RestController
public class RibbonController {
	
	@Autowired
	private  RestTemplate  restTemplate;
	
	@RequestMapping("/ribbon-test")
	String  test () {
		return  restTemplate.getForEntity ("http://provide-service/test",String.class).getBody ();
	}
	
}
