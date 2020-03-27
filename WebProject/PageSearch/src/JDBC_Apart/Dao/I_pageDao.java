package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.adancedQuery.ProductQueryObject;

/**
 * @ClassName: I_pageDao
 * @Description: 定义分页查询的Dao
 * @author: 汪哒哒
 * @date: 2019年7月6日 上午10:44:21
 */
public interface I_pageDao {
	/**
	 * @Title: list
	 * @Description: 高级查询
	 * @return
	 * @return: List<Mouse>
	 */
	List<Mouse> list();
	
	/**
	 * @Title: query
	 * @Description: 高级查询+分页查询
	 * @param go
	 * @return
	 * @return: List<Mouse>
	 */
	List<Mouse> query(ProductQueryObject go);
	/**
	 * @Title: query    分页查询
	 * @Description: TODO
	 * @param currPage  用户传入：当前用户需要跳转到那一页
	 * @param pageSize  用户传入：当前页最多显示多少条数据
	 * @return
	 * @return: PageResult
	 */
	List query(Integer currPage,Integer pageSize);
	

}
