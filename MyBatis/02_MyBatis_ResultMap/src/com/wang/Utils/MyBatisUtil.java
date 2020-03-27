package com.wang.Utils;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory = null;
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		return factory.openSession();
	}
}
