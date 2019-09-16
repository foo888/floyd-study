package com.floyd.interceptor.springbootinterceptor.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 请求示例对象
 *
 * @author floyd
 * @version : RequestUser.java, v 0.1 2019/9/16 14:52 By floyd Edit  $$
 */

@Data
public class RequestUser implements Serializable {
	
	@NotNull (message = "用户ID不能为空")
	private Integer userId;
	
	@NotNull(message = "用户名称不能为空")
	private String userName;
	
	@Max (value = 65, message = "年龄不在规定范围内")
	@Min (value = 18,message = "年龄不在规定范围内")
	private Integer age;
	
}
