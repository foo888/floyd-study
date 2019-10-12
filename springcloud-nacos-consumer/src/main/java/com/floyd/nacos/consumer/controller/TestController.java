package com.floyd.nacos.consumer.controller;

import com.floyd.nacos.consumer.config.Config;
import com.floyd.nacos.consumer.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 注释
 *
 * @author floyd
 * @version : TestController.java, v 0.1 2019/10/11 9:50 By floyd Edit  $$
 */
@RestController
@Slf4j
public class TestController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired(required = false)
	private TestService  echoService;
	
	@Autowired
	private Config  config;
	
	/**
	 * nacos配置测试
	 * @return
	 */
	@GetMapping (value = "/config-test")
	public String testConfig (){
		log.info ("nacos配置文件属性http.url={}",config.getUrl ());
		
		log.info ("nacos配置文件属性http.name={}",config.getName ());
		
		return config.getUrl ();
	}
	
	/**
	 *  RestTemplate 请求
	 * @param str
	 * @return
	 */
	@GetMapping (value = "/echo-rest/{str}")
	public String rest(@PathVariable String str) {
		
		String  result =  restTemplate.getForObject("http://nacos-server-provider/echo/" + str, String.class);
		
		log.info ("服务生产者返回的结果：{}",result);
		return  result;
	}
	
	/**
	 *  FeignClient 请求
	 * @param str
	 * @return
	 */
	@GetMapping(value = "/echo-feign/{str}")
	public String feign(@PathVariable String str) {
		return echoService.echo(str);
	}
}
