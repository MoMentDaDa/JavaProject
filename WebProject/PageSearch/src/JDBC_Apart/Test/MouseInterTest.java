package JDBC_Apart.Test;

import java.util.List;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.I_MouseDir;
import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.MouseInter;
import JDBC_Apart.Impl.MouseImpl;
import JDBC_Apart.Impl.Mouse_Dir_Impl;
import JDBC_Apart.Util.MouseQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

class MouseInterTest {
	MouseInter dao = new MouseImpl();
	I_MouseDir dao1 = new Mouse_Dir_Impl();

	@Test
	void testList() {
		System.out.println(dao.list());

	}

	@Test
	void testGet() {
		System.out.println(dao.get(164));
	}

	@Test
	void testSave() {
		Mouse m = new Mouse();

		dao.save(m);
	}

	@Test
	void testUpdate() {
		Mouse m = new Mouse();

		dao.update(m, 183);
	}

	@Test
	void testDelete() {
		dao.delete(182);
	}

	/*
	 * @Test void testAdvancedSearch() { System.out.println(dao.advancedSearch("G",
	 * "300", "100").toString()); }
	 */
	@Test
	List<Mouse> testadvancedSearch() {
		ProductQueryObject go = new ProductQueryObject();
		/*
		 * go.setName("G"); go.setMaxPrice("300"); go.setMinPrice("100");
		 */
		List<Mouse> list = dao.advancedSearch(go);
		System.out.println(list.size());
		for (Mouse mouse : list) {
			System.out.println(mouse.toString());
		}
		return list;
	}

}
