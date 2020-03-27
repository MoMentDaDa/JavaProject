package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.Object.MouseDir;

/**
 * @ClassName: I_MouseDir
 * @Description: 定义分类查询接口
 * @author: 汪哒哒
 * @date: 2019年7月10日 上午10:33:08
 */
public interface MouseDir_Dao {
	List<MouseDir> list();

	MouseDir get(int id);

	void save(MouseDir newMou);

	void update(MouseDir newMou, int id);

	void delete(int id);

}
