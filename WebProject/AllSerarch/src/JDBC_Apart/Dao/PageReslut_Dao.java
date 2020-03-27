package JDBC_Apart.Dao;

import JDBC_Apart.Object.PageResult;
import JDBC_Apart.adancedQuery.ProductQueryObject;

public interface PageReslut_Dao {
	PageResult pageInfo(Integer currentpage, Integer pagesize, ProductQueryObject go);

}
