package com.wang.Test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Domain.Department;
import com.wang.Domain.Employee;
import com.wang.Mapper.DepartmentMapper;
import com.wang.Mapper.EmployeeMapper;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	// 保存一个部门和两个员工
	@Test
	public void test1() {
		Department d = new Department();
		d.setName("开发部");

		Employee e1 = new Employee();
		e1.setName("张三");

		Employee e2 = new Employee();
		e2.setName("李四");

		// 维护对象之间的关系
		e1.setDept(d);
		e2.setDept(d);
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		departmentMapper.save(d);
		employeeMapper.save(e1);
		employeeMapper.save(e2);
		session.commit();
	}

	// 查询员工信息
	@Test
	public void test2() {
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee employee = employeeMapper.get(1L);
		System.out.println(employee);
		System.out.println(employee.getDept());

	}

	// 查询所有员工信息
	@Test
	public void test3() {
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		List<Employee> e = employeeMapper.listAll();
		for (Employee employee : e) {
			System.out.println(employee.toString());
		}
	}

}
