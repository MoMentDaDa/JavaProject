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
	// �������ӳض���
	public DataSource GetDataSource() {
		// �������Ӷ���
		BasicDataSource ds = new BasicDataSource();
		// �����������ݿ���Ҫ��
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

//ʹ�������ļ�ʵ�ֽ���
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

//ʹ�õ�³���������ݿ�
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
