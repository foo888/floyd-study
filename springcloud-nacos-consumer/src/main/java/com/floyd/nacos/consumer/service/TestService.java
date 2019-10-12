package com.floyd.nacos.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 注释
 *
 * @author floyd
 * @version : TestService.java, v 0.1 2019/10/11 9:47 By floyd Edit  $$
 */


@FeignClient (name = "nacos-server-provider")
public interface TestService {
	
	@GetMapping (value = "/echo/{str}")
	String echo(@PathVariable ("str") String str);

}
