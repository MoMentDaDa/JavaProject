package JDBC_Apart.Util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class DataSource2 implements javax.sql.DataSource {
	// 1. 创建一个容器用于存储Connection对象
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	// 2.创建5个连接放到容器中去
	static {
		for (int i = 0; i < 5; i++) {
			Connection conn = connection_util.getcom();
			// 放入池子中的Connection对象已经经过改造
			ConnectionWarp myconn = new ConnectionWarp(conn, pool);
			pool.add(myconn);
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		// 3.使用前先判断
		if (pool.size() == 0) {
			// 4.再创建5个连接
			for (int i = 0; i < 5; i++) {
				conn = connection_util.getcom();
				ConnectionWarp myconn = new ConnectionWarp(conn, pool);
				pool.add(myconn);
			}
		}
		// 5.从池子里获取连接对象Connection
		conn = pool.remove(0);
		return conn;
	}

	public void backConnection(Connection conn) {
		pool.add(conn);
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}