package com.wang.Params;

import lombok.AllArgsConstructor;
import lombok.Getter;

//用于封装登录的参数信息,
//VO:值对象
//DTO:数据转换对象
@AllArgsConstructor
@Getter
public class LoginVO {
	private String name;
	private String password;

}
