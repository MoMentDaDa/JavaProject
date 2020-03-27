package com.wang.Test;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Domain.Employee;
import com.wang.Domain.PageResult;
import com.wang.Impl.IEmployee;
import com.wang.Impl.LimitServerImpl;
import com.wang.Mapper.EmployeetMapper;
import com.wang.Params.AdvanceParams;
import com.wang.Params.QueryParams;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	// 高级查询，按指定要求查询
	@Test
	public void test1() {
		AdvanceParams params = new AdvanceParams();
		params.setKeyWord("2");
		params.setMinSalary(new BigDecimal("1000"));
		params.setMaxSalary(new BigDecimal("2000"));
		params.setDeptId(30);
		SqlSession session = MyBatisUtil.getSession();
		EmployeetMapper mapper = session.getMapper(EmployeetMapper.class);
		List<Employee> ems = mapper.queryList(params);
		for (Employee e : ems) {
			System.out.println(e);
		}
	}

	// 高级查询查询结果数
	@Test
	public void test2() {
		AdvanceParams params = new AdvanceParams();
		params.setDeptId(10);
		SqlSession session = MyBatisUtil.getSession();
		EmployeetMapper mapper = session.getMapper(EmployeetMapper.class);
		int count = mapper.queryForCount(params);
		System.out.println(count);
	}

	// 高级分页查询
	@Test
	public void test3() {
		AdvanceParams go = new AdvanceParams();
		IEmployee service = new LimitServerImpl();
		go.setDeptId(10);
		//go.setPageSize(1);
		//go.setCurrentPage(2);
		PageResult pageResult = service.limtQuery(go);
		System.out.println(pageResult.getTotalCount());
		for (Object o : pageResult.getResult()) {
			System.out.println(o);
		}
		 
	}

}
