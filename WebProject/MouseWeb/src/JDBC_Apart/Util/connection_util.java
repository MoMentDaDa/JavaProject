package JDBC_Apart.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class connection_util {
	private static Properties p = new Properties();
	static LinkedList<Connection> pool = new LinkedList<>();
	static DataSource dataSource;

	// 读取和加载properties文件
	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			p.load(in);
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// //获取连接
	public static Connection getcom() {
		try {
			Connection com = dataSource.getConnection();
			return com;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 关闭释放连接
	static void relase(Connection com, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e2) {
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
			} finally {
				try {
					if (com != null) {
						com.close();
					}
				} catch (Exception e) {
				}
			}
		}
	}

	public static Connection realGetcom() {
		// System.out.println("从池中获取一个连接");
		Connection conn = pool.removeFirst();
		// System.out.println(conn);
		ConnectionWarp myConn = new ConnectionWarp(conn, pool);
		return conn;
	}
}
