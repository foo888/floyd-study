package com.floyd.nacos.consumer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 注释
 *
 * @author floyd
 * @version : config.java, v 0.1 2019/10/11 12:04 By floyd Edit  $$
 */

@Component
@Data
@RefreshScope
@ConfigurationProperties(prefix = "http")
public class Config {
	
	private String url;
	
	private String name;
}
