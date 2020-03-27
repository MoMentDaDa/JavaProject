package com.wang.Test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Domain.Student;
import com.wang.Mapper.StudentMapper;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	// 一级缓存是 SqlSession 级别的，作用不大，因为每次查询都是一个新的 SqlSession,默认已经开启
	@Test
	public void testGet() {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student s = studentMapper.get(2L);
		System.out.println(s.hashCode());
		System.out.println("----------------------");// 由于一级缓存的存在，因此数据库第一先到缓存里面找，找到后放到缓存区域，所以s1 和s2 为同一个对象
		session.clearCache();// 清空一级缓存
		Student s2 = studentMapper.get(2L);
		System.out.println(s2.hashCode());
	}

	// 二级缓存是 mapper 级别的，需要和命名空间绑定
	@Test
	public void testGet2() throws InterruptedException {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student s = studentMapper.get(2L);
		System.out.println(s.hashCode());
		session.close();
		System.out.println("---------------------------------");
		Thread.sleep(3000);
		session = MyBatisUtil.getSession();
		studentMapper = session.getMapper(StudentMapper.class);
		Student s2 = studentMapper.get(2L);
		System.out.println(s2.hashCode());
		session.close();
	}

}
