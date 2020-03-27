package com.wang.Mapper;

import java.util.List;

import com.wang.Domain.Employee;

//高级查询+分页查询
public interface EmployeeMapper {
	//保存员工
	void save(Employee e);
	//查询员工信息
	Employee get(Long id);

	List<Employee> listAll();
}
