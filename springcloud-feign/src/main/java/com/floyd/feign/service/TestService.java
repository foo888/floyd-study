package com.floyd.feign.service;

import com.floyd.feign.domian.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 注释
 *
 * @author floyd
 * @version : TestService.java, v 0.1 2019/9/2 9:45 By floyd Edit  $$
 */

@FeignClient("provide-service")
public interface TestService {
	
	@RequestMapping("/test")
	String  test();
	
	@RequestMapping ("/req_name")
	String  test ( @RequestParam("name") String name);
	
	@RequestMapping ("/qry_user")
	UserDto  test ( @RequestHeader("name") String name,@RequestHeader("age") Integer age );
	
	@RequestMapping("/qry_inf")
	String  test ( @RequestBody UserDto user);
	
	
}
