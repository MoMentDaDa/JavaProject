package Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.alibaba.druid.pool.DruidDataSource;

import Register.Action.EmployeeAction;

@SpringJUnitConfig
class TestDemo {

	private DruidDataSource ds;

//传统的数据库连接方法
	@Test
	public void test() throws SQLException {
		ds = new DruidDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring");
		ds.setUsername("will");
		ds.setPassword("will123");

		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getLong("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("age"));
		}
	}

	// 使用 XML 配置的方式连接数据库
	@Autowired
	private DataSource DS;

	@Test
	void test2() throws Exception {
		Connection con = DS.getConnection();
		java.sql.PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("age"));
		}
	}

	@Autowired
	private EmployeeAction action;

	@Test
	void test3() throws Exception {
		action.execute();
	}
}
