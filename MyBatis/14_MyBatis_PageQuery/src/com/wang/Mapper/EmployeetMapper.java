package com.wang.Mapper;

import java.util.List;

import com.wang.Domain.Employee;
import com.wang.Params.QueryObject;

//高级查询+分页查询
public interface EmployeetMapper {
	// 高级查询
	List<Employee> queryList(QueryObject params);

	
	//高级+分页查询
	List<Employee> queryForLimit(QueryObject qo);

	List<Employee> listAll();
}
