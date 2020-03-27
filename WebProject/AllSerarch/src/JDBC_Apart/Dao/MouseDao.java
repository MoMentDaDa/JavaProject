package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.Object.Mouse;
import JDBC_Apart.Object.PageResult;
import JDBC_Apart.adancedQuery.AdancedQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

/**
 * @ClassName: MouseInter
 * @Description: ���������ɾ�Ĳ�ӿ�
 * @author: ������
 * @date: 2019��7��10�� ����10:35:26
 */
public interface MouseDao {
	List<Mouse> list();

	Mouse get(int id);

	void save(Mouse newMou);

	void update(Mouse newMou, int id);

	void delete(int id);

	// List<Mouse> advancedSearch(MouseQueryObject go);//���ǻ��ڶ������ʵ�ֲ�ѯ��
	List<Mouse> advancedSearch(ProductQueryObject go);// ���ǻ��ڼ̳����ʵ�ֲ�ѯ��

	/**
	 * @Title: page_advanced_Query
	 * @Description: �߼���ѯ�ͷ�ҳ��ѯ
	 * @param rs ��ҳ����
	 * @param go  ������װ�Ķ���
	 * @return: List  ����ҳ�����ͽ����
	 */
	List page_advanced_Query(PageResult rs, ProductQueryObject go);

}
