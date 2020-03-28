package com.wang.Params;

import lombok.Data;

//封装员工高查询的分页数据
@Data
public class QueryParams {
	
	private int currentPage = 1;//当前页
	private int pageSize = 3;//页大小

	//分页查询: LIMIT  start,pageSize
	public int getStart() {
		return (currentPage - 1) * pageSize;
	}

	//如果字符串为空串,也应该设置为null
	public String emptyNull(String str) {
		return hasLength(str) ? str : null;
	}

	public boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

}