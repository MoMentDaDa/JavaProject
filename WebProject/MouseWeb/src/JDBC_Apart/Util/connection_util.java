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

	// ��ȡ�ͼ���properties�ļ�
	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			p.load(in);
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// //��ȡ����
	public static Connection getcom() {
		try {
			Connection com = dataSource.getConnection();
			return com;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// �ر��ͷ�����
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
		// System.out.println("�ӳ��л�ȡһ������");
		Connection conn = pool.removeFirst();
		// System.out.println(conn);
		ConnectionWarp myConn = new ConnectionWarp(conn, pool);
		return conn;
	}
}
