package JDBC_Apart.Dao;

import java.util.List;

public interface I_MouseDir {
	List<MouseDir> list();

	MouseDir get(int id);

	void save(MouseDir newMou);

	void update(MouseDir newMou, int id);

	void delete(int id);

}
