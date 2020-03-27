package com.wang.Impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.Mapper.EmployeetMapper;
import com.wang.Params.QueryObject;
import com.wang.Utils.MyBatisUtil;

public class LimitServerImpl implements IEmployee {
	private EmployeetMapper employeeMapper = MyBatisUtil.getMapper(EmployeetMapper.class);

	@Override
	public PageInfo<?> limtQuery(QueryObject qo) {
		// 设置当前页和页大小
		PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
		// 执行查询，返回已分好页的结果集
		List<?> list = employeeMapper.queryForLimit(qo);
		return new PageInfo<>(list);
	}

}
