package com.wang.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wang.Object.Mouse;
import com.wang.Utils.MyBatisUtil;

import lombok.Cleanup;

public class TestDemo {

	@Test
	public void testGetOne() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		Mouse u = session.selectOne("com.wang.Object.UserMapper.get", 163);
		System.out.println(u);
	}

	@Test
	public void testlistAll() throws IOException {
		@Cleanup // 等价于自动释放资源
		SqlSession session = MyBatisUtil.getSession();
		List<Mouse> userList = session.selectList("com.wang.Object.UserMapper.listAll");
		for (Mouse u : userList) {
			System.out.println(u);
		}

	}

	// 查询mouse的结果总数
	@Test
	public void getCount() throws IOException {
		SqlSession session = MyBatisUtil.getSession();
		int count = session.selectOne("com.wang.Object.UserMapper.getCount");
		session.commit();
		session.close();
		System.out.println(count);
	}
	// 查询mouse的name和price列
	@Test
	public void getMap() throws IOException {
		SqlSession session = MyBatisUtil.getSession();
		List<Map<String,Object>> userList = session.selectList("com.wang.Object.UserMapper.getMap");
		session.commit();
		session.close();
		for (Map<String,Object> u : userList) {
			System.out.println(u);
		}
	}
	

}
