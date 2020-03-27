package JDBC_Apart.Test;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.MouseDir_Dao;
import JDBC_Apart.Impl.MouseDir_Impl;
import JDBC_Apart.Object.MouseDir;

class I_MouseDirTest {
	MouseDir_Dao dao1 = new MouseDir_Impl();

	@Test
	void testList() {
		System.out.println(dao1.list().toString());
	}

	@Test
	void testGet() {
		System.out.println(dao1.get(1));
	}

	@Test
	void testSave() {
		MouseDir dir = new MouseDir();
		dir.setDirName("¿∂—¿ Û±Í");
		dir.setId(4);
		dao1.save(dir);
	}

	@Test
	void testUpdate() {
		MouseDir dir = new MouseDir();
		dir.setDirName("¿∂—¿ Û±Í");
		dir.setId(2);
		dao1.update(dir, 2);
	}

	@Test
	void testDelete() {
		dao1.delete(2);
	}

}
