package com.wang.Params;

import java.math.BigDecimal;

import lombok.Data;

//封装高级查询的参数
@Data
public class AdvanceParams extends QueryParams {
	private String keyWord;
	private BigDecimal minSalary;
	private BigDecimal maxSalary;
	private int deptId = -1;// 缺省为-1,表示查询所有

	public String getKeyword() {
		return emptyNull(keyWord);
	}
}
