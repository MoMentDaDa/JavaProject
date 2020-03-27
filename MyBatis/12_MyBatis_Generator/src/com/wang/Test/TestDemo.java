package com.wang.Test;

import java.util.List;

import org.junit.Test;

import com.wang.Domain.User;
import com.wang.Domain.UserExample;
import com.wang.Domain.UserExample.Criteria;
import com.wang.MapperDao.UserMapper;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	@Test
	public void test1() {
		UserMapper mapper = MyBatisUtil.getMapper(UserMapper.class);
		User u = new User();
		u.setId(2L);
		User a = mapper.selectByPrimaryKey(u);
		System.out.println(a);
	}

	// 查询userType 在2~10 之间的
	@Test
	public void test2() {
		UserMapper mapper = MyBatisUtil.getMapper(UserMapper.class);
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserTypeBetween(2, 4);
		mapper.selectByExample(example);
		// 查询在2~4之间，且名字带有3的老师
		criteria.andNameLike("%3%");
		mapper.selectByExample(example);
		List<User> list = mapper.selectByExample(example);
		System.out.println(list);

	}

}
