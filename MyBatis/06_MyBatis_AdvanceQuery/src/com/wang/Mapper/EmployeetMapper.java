package com.wang.Mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wang.Domain.Employee;

//使用注解开发
public interface EmployeetMapper {

	List<Employee> queryMinsalary(@Param("minSalary") BigDecimal minSalary);

	List<Employee> query2(@Param("minSalary") BigDecimal minSalary, @Param("maxSalary") BigDecimal maxSalary);

	// where元素的使用
	List<Employee> query3(@Param("minSalary") BigDecimal minSalary, @Param("maxSalary") BigDecimal maxSalary, @Param("deptId") int i);

	// 动态更新数据，通过Set和If连用，智能判断为空，不进行SQL连接，不为空则连接
	void update1(@Param("newEm") Employee newEm);

	// set元素使用

	// 批量删除
	void batchDelete(@Param("ids") int[] ids);

	// 批量插入
	void batchSave(@Param("em") List<Employee> em);

}
