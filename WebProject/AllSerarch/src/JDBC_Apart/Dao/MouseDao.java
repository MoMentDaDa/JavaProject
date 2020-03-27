package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.Object.Mouse;
import JDBC_Apart.Object.PageResult;
import JDBC_Apart.adancedQuery.AdancedQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

/**
 * @ClassName: MouseInter
 * @Description: 定义鼠标增删改查接口
 * @author: 汪哒哒
 * @date: 2019年7月10日 上午10:35:26
 */
public interface MouseDao {
	List<Mouse> list();

	Mouse get(int id);

	void save(Mouse newMou);

	void update(Mouse newMou, int id);

	void delete(int id);

	// List<Mouse> advancedSearch(MouseQueryObject go);//这是基于定义类而实现查询的
	List<Mouse> advancedSearch(ProductQueryObject go);// 这是基于继承类而实现查询的

	/**
	 * @Title: page_advanced_Query
	 * @Description: 高级查询和分页查询
	 * @param rs 分页对象
	 * @param go  参数封装的对象
	 * @return: List  返回页码对象和结果集
	 */
	List page_advanced_Query(PageResult rs, ProductQueryObject go);

}
