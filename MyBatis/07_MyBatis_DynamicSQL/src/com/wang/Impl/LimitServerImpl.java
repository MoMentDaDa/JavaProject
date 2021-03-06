package com.wang.Impl;

import java.util.Collections;
import java.util.List;

import com.wang.Domain.Employee;
import com.wang.Domain.PageResult;
import com.wang.Mapper.EmployeetMapper;
import com.wang.Params.QueryParams;
import com.wang.Utils.MyBatisUtil;

public class LimitServerImpl implements IEmployee {
	private EmployeetMapper employeeMapper = MyBatisUtil.getMapper(EmployeetMapper.class);

	@Override
	public PageResult limtQuery(QueryParams qo) {
		int rows = employeeMapper.queryForCount(qo);
		if (rows == 0) {
			return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
		}
		List<Employee> result = employeeMapper.queryForLimit(qo);
		return new PageResult(result, rows, qo.getCurrentPage(), qo.getPageSize());
	}

}
