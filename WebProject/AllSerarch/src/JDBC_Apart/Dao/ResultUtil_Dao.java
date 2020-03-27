package JDBC_Apart.Dao;

import java.sql.ResultSet;

//结果集处理规范接口
public interface ResultUtil_Dao<T> {
//传统方式处理结果集
	T handle(ResultSet rs) throws Exception;
}
