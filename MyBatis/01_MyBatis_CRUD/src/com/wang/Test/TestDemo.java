package com.wang.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.wang.Object.User;
import com.wang.Utils.MyBatisUtil;

import lombok.Cleanup;

public class TestDemo {
	private static Logger log = Logger.getLogger(TestDemo.class);

	@Test
	public void testLog() throws Exception {
		// 如果日志级别是INFO,就输出
		if (log.isInfoEnabled()) {
			log.info("银行转账操作");
		}
		if (log.isDebugEnabled()) {
			log.debug("查询数据库");
		}
		if (log.isTraceEnabled()) {
			log.trace("连接数据库");
		}
		if (log.isTraceEnabled()) {
			log.trace("获取连接对象");
		}
		if (log.isTraceEnabled()) {
			log.trace("执行SQL");
		}
		if (log.isDebugEnabled()) {
			log.debug("转账......");
		}

		if (log.isInfoEnabled()) {
			log.info("银行转账成功");
		}

	}

	@Test
	public void testGetOne() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		User u = session.selectOne("com.wang.Object.UserMapper.get", 163);
		System.out.println(u);
	}

	@Test
	public void testlistAll() throws IOException {
		@Cleanup // 等价于自动释放资源
		SqlSession session = MyBatisUtil.getSession();
		List<User> userList = session.selectList("com.wang.Object.UserMapper.listAll");
		for (User u : userList) {
			System.out.println(u);
		}

	}

	@Test
	public void testUpdate() throws IOException {
		User newUser=new User();
		newUser.setName("岳步玲");
		newUser.setPrice("1000");
		newUser.setId(187);
		SqlSession session = MyBatisUtil.getSession();
		session.update("com.wang.Object.UserMapper.update",newUser);
		session.commit();
		session.close();
	}
	
	@Test
	public void testDelete() throws IOException {
		SqlSession session = MyBatisUtil.getSession();
		session.delete("com.wang.Object.UserMapper.delete",187);
		session.commit();
		session.close();
	}
	
	@Test
	public void testSave() throws IOException {
		User newUser=new User();
		newUser.setName("岳步玲");
		newUser.setPrice("1000");
		SqlSession session = MyBatisUtil.getSession();
		session.insert("com.wang.Object.UserMapper.save",newUser);
		session.commit();
		session.close();
	}


}
