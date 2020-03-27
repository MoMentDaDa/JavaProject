package JDBC_Apart.Dao;

import java.util.List;

import JDBC_Apart.Util.MouseQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

public interface MouseInter {
	List<Mouse> list();

	Mouse get(int id);

	void save(Mouse newMou);

	void update(Mouse newMou, int id);

	void delete(int id);
	
	//List<Mouse> advancedSearch(MouseQueryObject go);//这是基于定义类而实现查询的
	List<Mouse> advancedSearch(ProductQueryObject go);//这是基于继承类而实现查询的
	
	

}
