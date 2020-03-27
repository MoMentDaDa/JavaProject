package JDBC_Apart.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class SqlUntil {
	private static Properties p = new Properties();
	// ��̬����������ֻ��һ��
	static {
		try {
			// ��ȡ�ͼ���properties�ļ�
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			p.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getcon() {
		try {
			DataSource dataSource = DruidDataSourceFactory.createDataSource(p);
			Connection com = dataSource.getConnection();
			return com;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection com, Statement st, ResultSet rs) {
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
	
	
}
