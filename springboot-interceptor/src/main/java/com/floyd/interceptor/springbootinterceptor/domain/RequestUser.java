package com.floyd.interceptor.springbootinterceptor.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	//@Pattern (regexp = "^.{6,12}$",message = "用户名不符合规范")
	@Length(min = 6,max = 12,message = "用户名不符合规范")
	private String userName;
	
	@Max (value = 65, message = "年龄不在规定范围内")
	@Min (value = 18,message = "年龄不在规定范围内")
	@NotNull( message = "年龄不能为空")
	private Integer age;
	
	@NotNull (message = "交易金额不能为空")
	@Pattern (regexp = "^([1-9][0-9]*)$", message = "无效的交易金额")
	private String tradeAmount;
}
