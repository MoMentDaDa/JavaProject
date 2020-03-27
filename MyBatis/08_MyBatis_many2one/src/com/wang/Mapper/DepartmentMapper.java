package com.wang.Mapper;

import com.wang.Domain.Department;

public interface DepartmentMapper {
	void save(Department d);

	//Department get(long id);  可以不需要，因为额外SQL 只是寻找语句，没有调用 Mapper 某个方法。所以不会报错
}
