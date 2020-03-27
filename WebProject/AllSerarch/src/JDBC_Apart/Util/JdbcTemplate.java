package JDBC_Apart.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import JDBC_Apart.Dao.ResultUtil_Dao;
import JDBC_Apart.Object.Mouse;

public class JdbcTemplate {
	static DataSource2 pool = new DataSource2();
	static Connection com = null;
	static PreparedStatement st = null;
	static List<Mouse> list = null;
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
			com = pool.getConnection();
			ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// 设置是第几个？，设置占位符的值
				ps.setObject(index + 1, params[index]);
				// 执行语句，返回行数
			}
			//System.out.println(ps.toString());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	public static <T> T Query(String sql, ResultUtil_Dao<T> rsh, Object... params) {
		try {
			com = pool.getConnection();
			ps = com.prepareStatement(sql);
			// System.out.println(ps.toString());
			// System.out.println(params.length);0
			if (params.length != 0) {
				for (int index = 0; index < params.length; index++) {
					// 设置是第几个？，设置占位符的值
					ps.setObject(index + 1, params[index]);
				}
			}
			//System.out.println(ps.toString());
			// 处理返回结果集
			return rsh.handle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("查询出错");
	}
}
