package com.wang.Test;

import java.util.List;

import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.Domain.Employee;
import com.wang.Impl.IEmployee;
import com.wang.Impl.LimitServerImpl;
import com.wang.Mapper.EmployeetMapper;
import com.wang.Params.EmployeeParams;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	// 高级查询，按指定要求查询
	@Test
	public void test1() {
		EmployeetMapper employeeMapper = MyBatisUtil.getMapper(EmployeetMapper.class);
		// ------------------------------------------------
		// 设置分页
		PageHelper.startPage(2, 2);
		// ------------------------------------------------
		List<Employee> list = employeeMapper.listAll();
		System.out.println("-----------------");
		for (Employee e : list) {
			System.out.println(e.toString());
		}
		System.out.println("-----------------");
		PageInfo pageinfo = new PageInfo<>(list);
		System.out.println("结果总数：" + pageinfo.getTotal());
		System.out.println("结果集：" + pageinfo.getList());
		System.out.println("上一夜：" + pageinfo.getPrePage());
		System.out.println("当前页：" + pageinfo.getPageNum() + "/" + pageinfo.getPages());
		System.out.println("下一页：" + pageinfo.getNextPage());
	}

	// 高级分页查询
	@Test
	public void test3() {
		EmployeeParams go = new EmployeeParams();
		IEmployee service = new LimitServerImpl();
		go.setCurrentPage(2);
		go.setPageSize(2);
		go.setNameWord("二");
		PageInfo pageResult = service.limtQuery(go);
		System.out.println(pageResult.getTotal());
		for (Object o : pageResult.getList()) {
			System.out.println(o);
		}
		System.out.println("上一夜：" + pageResult.getPrePage());
		System.out.println("当前页：" + pageResult.getPageNum() + "/" + pageResult.getPages());
		System.out.println("下一页：" + pageResult.getNextPage());

	}

}
