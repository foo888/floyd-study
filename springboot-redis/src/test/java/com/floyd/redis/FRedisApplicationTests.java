package com.floyd.redis;

import com.floyd.redis.config.RedisUtil;
import com.floyd.redis.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FRedisApplicationTests {
	
	private Logger logger =  LoggerFactory.getLogger (FRedisApplicationTests.class);
	
	@Autowired
	private RedisUtil  redisUtil;
	
	@Test
	public void contextLoads() {
		
		StringBuffer  msg = new StringBuffer ();
		
		msg.append ("set："+redisUtil.set ("20190828", "这是第一条测试数据"));
		msg.append ("\r\n");
		msg.append ("get："+redisUtil.get ("20190828"));
		msg.append ("\r\n");
		msg.append ("del："+redisUtil.del ("20190828"));
		logger.info ("信息：{}",msg.toString ());
		
		msg.setLength (0);
		
		Student  su = new Student (1,"小白",18,"一条酸菜鱼");
		msg.append ("set："+redisUtil.set("student",su));
		msg.append ("\r\n");
		msg.append ("get："+redisUtil.get ("student"));
		msg.append ("\r\n");
		msg.append ("del："+redisUtil.del ("student"));
		logger.info ("信息：{}",msg.toString ());
	}

}
