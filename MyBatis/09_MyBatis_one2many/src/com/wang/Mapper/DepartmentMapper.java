package com.wang.Mapper;

import com.wang.Domain.Department;

public interface DepartmentMapper {
	void save(Department d);

	Department get(long id);

}
