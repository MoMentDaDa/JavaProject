package com.wang.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Mapper.ClientMapper;
import com.wang.Object.Client;
import com.wang.Params.LoginVO;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	@Test
	public void testLogin1() {
		// 将多个参数对象封装到VO对象中
		LoginVO vo = new LoginVO("will", "1111");
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		Client client = mapper.login1(vo);
		System.out.println(client);
		session.close();
	}

	@Test
	public void testLogin2() {
		// 将多个参数封装在一个Map中
		Map<String, Object> paramsMap = new HashMap<String, Object>() {
			{
				this.put("name", "will");
				this.put("password", "1111");
			}
		};
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		Client client = mapper.login2(paramsMap);
		System.out.println(client);
		session.close();
	}

	@Test
	public void testLogin3() {
		// 使用注解开发
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		Client client = mapper.login3("will", "1111");
		System.out.println(client);
		session.close();
	}

	@Test
	public void testList() {
		// 使用注解开发
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		List<Client> clientList = mapper.list("id desc");
		for (Client client : clientList) {
			System.out.println(client);
		}
		session.close();
	}

}
