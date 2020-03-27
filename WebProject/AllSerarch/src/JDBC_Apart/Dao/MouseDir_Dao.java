package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.Object.MouseDir;

/**
 * @ClassName: I_MouseDir
 * @Description: ��������ѯ�ӿ�
 * @author: ������
 * @date: 2019��7��10�� ����10:33:08
 */
public interface MouseDir_Dao {
	List<MouseDir> list();

	MouseDir get(int id);

	void save(MouseDir newMou);

	void update(MouseDir newMou, int id);

	void delete(int id);

}
