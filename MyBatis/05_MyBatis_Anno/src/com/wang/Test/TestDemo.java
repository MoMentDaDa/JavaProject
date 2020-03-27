package com.wang.Test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Mapper.ClientMapper;
import com.wang.Object.Client;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	// 不使用注解开发
	@Test
	public void testList() {
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		List<Client> clientList = mapper.listAll2();
		for (Client client : clientList) {
			System.out.println(client);
		}
		session.close();
	}

	// 不使用注解保存
	@Test
	public void testsave() {
		Client client = new Client();
		client.setName("luck");
		client.setPassword("3333");
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		mapper.save1(client);
		session.commit();
		session.close();
	}

	// 使用注解保存
	@Test
	public void testSave2() {
		Client client = new Client();
		client.setName("tony");
		client.setPassword("4444");
		System.out.println(client);
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		mapper.save2(client);
		session.commit();
		session.close();
		System.out.println(client);
	}

	// 使用注解更新
	@Test
	public void testUpdate() {
		Client client = new Client();
		client.setName("tony");
		client.setPassword("5555");
		client.setId(7);
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		mapper.update(client);
		session.commit();
		session.close();
	}

	// 使用注解删除
	@Test
	public void testDelete() {
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		mapper.delete(7);
		session.commit();
		session.close();
	}

	// 使用注解获取单个
	@Test
	public void testgetOne() {
		SqlSession session = MyBatisUtil.getSession();
		ClientMapper mapper = session.getMapper(ClientMapper.class);
		Client client = mapper.get(4);
		System.out.println(client);
		session.close();
	}

	// 使用注解查询所有
		@Test
		public void testgetALL() {
			SqlSession session = MyBatisUtil.getSession();
			ClientMapper mapper = session.getMapper(ClientMapper.class);
			List<Client> client = mapper.listAll();
			session.close();
			for (Client c : client) {
				System.out.println(c);
			}
		}

}
