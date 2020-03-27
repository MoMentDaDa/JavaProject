package JDBC_Apart.Test;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.I_MouseDir;
import JDBC_Apart.Dao.MouseDir;
import JDBC_Apart.Impl.Mouse_Dir_Impl;

class I_MouseDirTest {
	I_MouseDir dao1 = new Mouse_Dir_Impl();

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
