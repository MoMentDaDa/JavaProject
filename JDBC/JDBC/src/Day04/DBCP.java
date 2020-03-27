package Day04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBCP {
	// 创建连接池对象
	public DataSource GetDataSource() {
		// 创建连接对象
		BasicDataSource ds = new BasicDataSource();
		// 创建连接数据库四要素
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}

	@Test
	public void ConnectionData() throws Exception {
		DataSource ds = this.GetDataSource();
		Connection com = ds.getConnection();
		PreparedStatement ps = com.prepareStatement("SELECT * FROM t_student");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
		}
	}

//使用配置文件实现解耦
	@Test
	public void ConnectionByProperties() throws Exception {
		Properties p = new Properties();
		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(p);
		Connection com = dataSource.getConnection();
		PreparedStatement ps = com.prepareStatement("SELECT * FROM t_student");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
		}
	}

//使用德鲁伊连接数据库
	@Test
	public void ConnectionByPropertiesWithDruid() throws Exception {
		Properties p = new Properties();
		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		DataSource dataSource = DruidDataSourceFactory.createDataSource(p);
		Connection com = dataSource.getConnection();
		PreparedStatement ps = com.prepareStatement("SELECT * FROM t_student");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
		}
	}
}
