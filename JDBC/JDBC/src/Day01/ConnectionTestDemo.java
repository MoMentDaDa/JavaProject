package Day01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTestDemo {
	@Test
	public void test1() throws Exception {
		// 手动获取数据库对象
		Class.forName("com.mysql.jdbc.Driver");
		// 连接jdbcdatabase数据库
		Connection com =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		Thread.sleep(20000);
	}
	@Test
	public void test2() throws Exception {
		// Java1.6开始支持自动获取数据库对象，连接jdbcdatabase数据库
		Connection com =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase", "root", "admin");
		Thread.sleep(10000);
	}
}
