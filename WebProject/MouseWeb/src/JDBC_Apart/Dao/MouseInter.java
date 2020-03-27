package JDBC_Apart.Dao;

import java.util.List;

public interface MouseInter {
	List<Mouse> list();

	Mouse get(int id);

	void save(Mouse newMou);

	void update(Mouse newMou, int id);

	void delete(int id);
}
