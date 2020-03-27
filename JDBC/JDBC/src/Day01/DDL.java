package Day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DDL {
	// 创建t_student表
	@Test
	public void test1() throws Exception {
		String sql = "CREATE TABLE `t_student2`(`id` BIGINT,`name` VARCHAR(20),`email` VARCHAR(20),`age`  INT);";
		// 加载获取连接数据库对象
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		// 创建Statement对象，用于传输sql语句
		Statement st = com.createStatement();
		// 3、执行SQL语句
		int row = st.executeUpdate(sql);
		st.close();
		com.close();
		System.out.println(row);
	}

//给表添加数据
	@Test
	public void test2() throws Exception {
		String sql="insert into t_student(id,name,age) VAlUES(1,'乔峰',30)";
		String sql2="insert into t_student(id,name,age) VAlUES(2,'西门春雪',10)";
		String sql3="DELETE FROM t_student WHERE id=1";
		// 加载获取连接数据库对象
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		// 创建Statement对象，用于传输sql语句
		Statement st = com.createStatement();
		Statement st2 = com.createStatement();
		// 3、执行SQL语句
		int row = st.executeUpdate(sql3);
		st.close();
		com.close();
		System.out.println(row);
	}
}
