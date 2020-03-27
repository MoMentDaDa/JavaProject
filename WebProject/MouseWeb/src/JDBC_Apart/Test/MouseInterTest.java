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
		newM.setName("������");
		newM.setPrice("100");
		newM.setWeight("18��");
		newM.setMaterial("שʯ");
		newM.setEngineering("�㽶");
		dao.save(newM);
	}

	@Test
	void testUpdate() {
		Mouse newM = new Mouse();
		newM.setName("������");
		newM.setPrice("500");
		newM.setWeight("100��");
		newM.setMaterial("שʯ");
		newM.setEngineering("�㽶");
		dao.update(newM, 37);
	}

	@Test
	void testDelete() {
		dao.delete(33);
	}

}
