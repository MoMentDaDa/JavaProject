package JDBC_Apart.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JDBC_Apart.Dao.User_Dao;
import JDBC_Apart.Object.User;
import JDBC_Apart.Util.DataSource2;

public class User_Impl implements User_Dao {
	DataSource2 pool = new DataSource2();
	Connection com = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	User u = null;
	@Override
	public User getUserName(String username) {
		String sql = "select * from m_user where username=?";
		try {
			com = pool.getConnection();
			st = com.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUsername(username);
				u.setPassword(rs.getString("password"));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
