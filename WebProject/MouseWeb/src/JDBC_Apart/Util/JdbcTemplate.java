package JDBC_Apart.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.ResultUtil;



public class JdbcTemplate {
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static int row;

	/**
	 * O DML操作（增删改）模版
	 * 
	 * @param sql    DML操作的SQL模板（带有占位符）
	 * @param params SQL模板中？对应的参数值
	 * @return 行数
	 */
	public static int Update(String sql, Object... params) {
		try {
			//ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// 设置是第几个？，设置占位符的值
				ps.setObject(index + 1, params[index]);
				// 执行语句，返回行数
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// SqlUntil.close(com, ps, null);
		}
		return 0;
	}

	private static void isNull(Object[] val, Mouse oldm) {

	}

//判断值是否相同

	/**
	 * DML 操作模版
	 * 
	 * @param sql    传入的SQL语句
	 * @param params SQL中占位符
	 * @return 返回查询的List结果集
	 */
	public static <T> T Query(String sql, ResultUtil<T> rsh, Object... params) {
		try {
			//ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// 设置是第几个？，设置占位符的值
				ps.setObject(index + 1, params[index]);
			}
			// 处理返回结果集
			return rsh.handle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// SqlUntil.close(com, ps, rs);
		}
		throw new RuntimeException("查询出错");
	}
}
