package JDBC_Apart.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.MouseDao;
import JDBC_Apart.Dao.MouseDir_Dao;
import JDBC_Apart.Dao.PageReslut_Dao;
import JDBC_Apart.Impl.MouseDir_Impl;
import JDBC_Apart.Impl.Mouse_Impl;
import JDBC_Apart.Impl.PageDao_Impl;
import JDBC_Apart.Object.PageResult;
import JDBC_Apart.adancedQuery.ProductQueryObject;

class MouseDaoTest {
	MouseDao dao = new Mouse_Impl();
	MouseDir_Dao dirDao = new MouseDir_Impl();
	private PageReslut_Dao pageDao = new PageDao_Impl();

	@Test
	void testList() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testAdvancedSearch() {
		fail("Not yet implemented");
	}

	@Test
	void testPage_advanced_Query() {

		Integer curretPage = 2;// 当前页
		Integer pageSize = 3;// 每页条数
		ProductQueryObject go = new ProductQueryObject();
		go.setMinPrice("100");
		go.setMaxPrice("300");
		PageResult p = pageDao.pageInfo(curretPage, pageSize, go);
		dao.page_advanced_Query(p, go);
	}

}
