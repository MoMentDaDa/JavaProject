package com.wang.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Domain.Employee;
import com.wang.Mapper.EmployeetMapper;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	// 查询工资高于等于1000 的。
	@Test
	public void test1() {
		EmployeetMapper mapper = MyBatisUtil.getMapper(EmployeetMapper.class);
		BigDecimal minSalary = new BigDecimal("1000");
		List<Employee> list = mapper.queryMinsalary(minSalary);
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	// 查询工资在1000~2000的
	@Test
	public void test2() {
		EmployeetMapper mapper = MyBatisUtil.getMapper(EmployeetMapper.class);
		BigDecimal minSalary = new BigDecimal("1000");
		BigDecimal maxSalary = new BigDecimal("2000");
		List<Employee> list = mapper.query2(minSalary, maxSalary);
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	// 查询指定部门的员工信息
	@Test
	public void test3() {
		EmployeetMapper mapper = MyBatisUtil.getMapper(EmployeetMapper.class);
		BigDecimal minSalary = new BigDecimal("100");
		BigDecimal maxSalary = new BigDecimal("2000");
		List<Employee> list = mapper.query3(minSalary, maxSalary, 20);
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	// 查询指定部门的员工信息
	@Test
	public void test4() {
		EmployeetMapper mapper = MyBatisUtil.getMapper(EmployeetMapper.class);
		BigDecimal minSalary = new BigDecimal("100");
		BigDecimal maxSalary = new BigDecimal("2000");
		List<Employee> list = mapper.query3(minSalary, maxSalary, 20);
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	// 批量插入数据
	@Test
	public void test6() {
		SqlSession session = MyBatisUtil.getSession();
		Employee e1 = new Employee("诸葛亮", "009", 40);
		e1.setSalary(new BigDecimal("3000"));
		Employee e2 = new Employee("章鱼", "010", 25);
		e2.setSalary(new BigDecimal("1300"));
		List<Employee> ems = new ArrayList<>();
		ems.add(e1);
		ems.add(e2);
		EmployeetMapper mapper = session.getMapper(EmployeetMapper.class);
		mapper.batchSave(ems);
		session.commit();
	}

	// 批量删除指定部门的员工信息
	@Test
	public void test5() {
		SqlSession session = MyBatisUtil.getSession();
		EmployeetMapper mapper = session.getMapper(EmployeetMapper.class);
		mapper.batchDelete(new int[] { 17, 18});
		// DELETE FROM employee WHERE id IN ( ? , ? , ? , ? ) Parameters: 10(Integer), 11(Integer), 12(Integer), 13(Integer)
		session.commit();
	}
	
	

}
