package JDBC_Apart.Test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import JDBC_Apart.Dao.I_pageDao;
import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.PageResult;
import JDBC_Apart.Impl.PageDao_Impl;
import Web_Apart.pageServlet;

class I_pageDaoTest {
	private I_pageDao dao = new PageDao_Impl();

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
		Integer curretPage = 1;// ��ǰҳ
		Integer pageSize = 8;// ÿҳ����
		List<Object> pageResult = dao.query(curretPage, pageSize);
		PageResult p = (PageResult) pageResult.get(0);
		System.out.println(p.toString());
		List<Mouse> m = (List<Mouse>) pageResult.get(1);
		System.out.println(m.toString());
		System.out.println("��������" + p.getTotalCount());
		System.out.println("��ǰҳ��" + p.getCurrentPage() + "   " + "��һҳ��" + p.getPrevPage() + "   " + "��һҳ:"
				+ p.getNextPage());

	}

}
