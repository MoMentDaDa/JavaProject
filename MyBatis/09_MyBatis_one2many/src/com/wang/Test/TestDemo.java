package com.wang.Test;

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
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		SqlSession session = MyBatisUtil.getSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		departmentMapper.save(d);
		e1.setDept_id(d.getId());
		e2.setDept_id(d.getId());
		employeeMapper.save(e1);
		employeeMapper.save(e2);
		session.commit();
	}

	// 查询10号部门的信息和包含员工信息
	@Test
	public void test2() {
		SqlSession session = MyBatisUtil.getSession();
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		Department d = departmentMapper.get(1L);
		System.out.println(d);
		System.out.println(d.getEmps().toString());
	}

}
