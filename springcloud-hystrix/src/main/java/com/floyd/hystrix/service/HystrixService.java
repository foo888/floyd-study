package com.floyd.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 注释
 *
 * @author floyd
 * @version : HystrixService.java, v 0.1 2019/8/30 14:33 By floyd Edit  $$
 */

@Service
public class HystrixService {
	
	private final Logger  logger = LoggerFactory.getLogger (HystrixService.class);
	
	@Autowired
	RestTemplate  restTemplate;
	
	@HystrixCommand(fallbackMethod = "errorBack",groupKey = "",threadPoolKey = "",
		commandProperties={
			//服务调用超时时间
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
			//HystrixCommand隔离级别：Thread表示重新开始一个线程执行回滚；SEMAPHORE表示在当前调用线程执行回滚
			,@HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")
			//@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
			
			//设置并发数，默认10 ，当达到该值，后续请求会被拒绝
			,@HystrixProperty (name = "execution.isolation.semaphore.maxConcurrentRequests",value = "2")
			
		},
		threadPoolProperties = {
			@HystrixProperty(name = "coreSize",value = "1"),
			@HystrixProperty(name = "maxQueueSize",value = "10")
		}
		
	)
	public String  getServer(){
		long start = System.currentTimeMillis ();
		logger.info ("开始 -->");
		String str = restTemplate.getForEntity ("http://provide-service/test",String.class).getBody ();
		logger.info ("响应 --> {},耗时：{}",str,(System.currentTimeMillis ()-start));
		return str;
	}
	
	
	public String  errorBack(){
		return "server error!";
	}
}
