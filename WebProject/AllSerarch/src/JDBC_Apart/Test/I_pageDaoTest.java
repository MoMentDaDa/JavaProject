package JDBC_Apart.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.PageReslut_Dao;
import JDBC_Apart.Impl.PageDao_Impl;
import JDBC_Apart.Object.PageResult;
import JDBC_Apart.adancedQuery.ProductQueryObject;

class I_pageDaoTest {
	private PageReslut_Dao dao = new PageDao_Impl();

	@Test
	void testList() {
		fail("Not yet implemented");
	}

	@Test
	void testQueryProductQueryObject() {
		fail("Not yet implemented");
	}

	@Test
	void testQueryIntegerInteger() {
		fail("Not yet implemented");
	}

	@Test
	void test2() {
		Integer curretPage = 2;// ��ǰҳ
		Integer pageSize = 3;// ÿҳ����
		ProductQueryObject go = new ProductQueryObject();
		go.setMinPrice("100");
		go.setMaxPrice("300");
		PageResult p = dao.pageInfo(curretPage, pageSize, go);
		System.out.println(p.toString());
		System.out.println("��������" + p.getTotalCount());
		System.out.println(
				"��ǰҳ��" + p.getCurrentPage() + "   " + "��һҳ��" + p.getPrevPage() + "   " + "��һҳ:" + p.getNextPage());

	}

}
