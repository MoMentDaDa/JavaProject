package Day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class DQL {
	// 查询操作
	@Test
	public void test1() throws Exception {
		// 加载获取连接数据库对象
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		// 创建Statement对象，用于传输sql语句
		Statement st = com.createStatement();
		// 创建SQL语句
		String sql = "SELECT COUNT(name) rows FROM t_student";
		ResultSet r = st.executeQuery(sql);
		if (r.next()) {
			long totalCount = r.getLong("rows");
			System.out.println(totalCount);
		}
		r.close();
		st.close();
		com.close();
	}

	@Test
	public void test2() throws Exception {
		// 创建SQL语句
		String sql = "SELECT * FROM t_student WHERE id=2";
		// 手动获取数据库对象
		Class.forName("com.mysql.jdbc.Driver");
		// 连接jdbcdatabase数据库
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		Thread.sleep(2000);
		// 创建Statement对象，用于传输sql语句
		Statement st = com.createStatement(); // 执行SQL查询语句
		ResultSet r = st.executeQuery(sql);
		if (r.next()) {
			long totalCount = r.getLong("id");
			String name = r.getString("name");
			int age = r.getInt("age");
			System.out.println("name:" + name + ",age:" + age);
		}
		r.close();
		st.close();
		com.close();
	}
}
