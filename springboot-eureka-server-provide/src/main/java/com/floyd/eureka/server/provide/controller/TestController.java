package com.floyd.eureka.server.provide.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 注释
 *
 * @author floyd
 * @version : TestController.java, v 0.1 2019/8/29 14:51 By floyd Edit  $$
 */
@RestController
public class TestController {
	
	@Autowired
	private DiscoveryClient  discoveryClient;
	
	@RequestMapping ("/test")
	public String index () throws Exception{
		
		
		
		List<String>  services  = discoveryClient.getServices ();
		Date date = new Date ();
		System.out.println ("信息："+discoveryClient.description ()+""+date.toString ());
		if (!CollectionUtils.isEmpty (services)) {
			services.stream ().forEach (s -> {
				System.out.println (">>>:"+s);
			});
		}
		
		int sleepTime  = new Random ().nextInt (3000);
		System.out.println (date.toString ()+" 休眠时间："+sleepTime);
		Thread.sleep (sleepTime);
		
		return "YES";
	}
}
