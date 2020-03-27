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

import com.wang.MapperDao.UserMapper;

public class TestDemo {
	@Test
	public void test1() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(in);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Map<String, Object>> list = mapper.listMap();
		session.close();
		System.out.println("--------------");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

}
