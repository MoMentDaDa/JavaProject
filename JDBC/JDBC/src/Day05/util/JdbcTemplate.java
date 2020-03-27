package Day05.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Day05.DaoMain.Student;
import Day05.Impl.ResultImpl;
import Day05.Impl.ResultUtil;

public class JdbcTemplate {
	static Connection com = Day05.util.SqlUntil.getcon();
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static List<Student> list = new ArrayList();
	static int row;

	/**
	 * DML操作（增删改）模版
	 * 
	 * @param sql    DML操作的SQL模板（带有占位符）
	 * @param params SQL模板中？对应的参数值
	 * @return 行数
	 */
	public static int Update(String sql, Object... params) {
		try {
			ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {

				// 设置是第几个？，设置占位符的值
				ps.setObject(index + 1, params[index]);
				// 执行语句，返回行数
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, null);
		}
		return 0;
	}

	/**
	 * DML 操作模版
	 * 
	 * @param sql    传入的SQL语句
	 * @param params SQL中占位符
	 * @return 返回查询的List结果集
	 */
	public static <T>T Query(String sql, ResultUtil<T> rsh, Object... params) {
		try {
			ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// 设置是第几个？，设置占位符的值
				ps.setObject(index + 1, params[index]);
			}
			// 处理返回结果集
			return rsh.handle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}
		throw new RuntimeException("查询出错");
	}
}
