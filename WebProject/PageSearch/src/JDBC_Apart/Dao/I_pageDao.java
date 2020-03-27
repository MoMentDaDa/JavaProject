package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.adancedQuery.ProductQueryObject;

/**
 * @ClassName: I_pageDao
 * @Description: �����ҳ��ѯ��Dao
 * @author: ������
 * @date: 2019��7��6�� ����10:44:21
 */
public interface I_pageDao {
	/**
	 * @Title: list
	 * @Description: �߼���ѯ
	 * @return
	 * @return: List<Mouse>
	 */
	List<Mouse> list();
	
	/**
	 * @Title: query
	 * @Description: �߼���ѯ+��ҳ��ѯ
	 * @param go
	 * @return
	 * @return: List<Mouse>
	 */
	List<Mouse> query(ProductQueryObject go);
	/**
	 * @Title: query    ��ҳ��ѯ
	 * @Description: TODO
	 * @param currPage  �û����룺��ǰ�û���Ҫ��ת����һҳ
	 * @param pageSize  �û����룺��ǰҳ�����ʾ����������
	 * @return
	 * @return: PageResult
	 */
	List query(Integer currPage,Integer pageSize);
	

}
