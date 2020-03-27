package JDBC_Apart.Test;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.MouseInter;
import JDBC_Apart.Impl.MouseImpl;

class MouseInterTest {
	MouseInter dao = new MouseImpl();

	@Test
	void testList() {
		dao.list();
		System.out.println(dao.list().toString());
	}

	@Test
	void testGet() {
		System.out.println(dao.get(3).toString());
	}

	@Test
	void testSave() {
		Mouse newM = new Mouse();
		newM.setName("爱国者");
		newM.setPrice("100");
		newM.setWeight("18斤");
		newM.setMaterial("砖石");
		newM.setEngineering("香蕉");
		dao.save(newM);
	}

	@Test
	void testUpdate() {
		Mouse newM = new Mouse();
		newM.setName("爱国者");
		newM.setPrice("500");
		newM.setWeight("100斤");
		newM.setMaterial("砖石");
		newM.setEngineering("香蕉");
		dao.update(newM, 37);
	}

	@Test
	void testDelete() {
		dao.delete(33);
	}

}
