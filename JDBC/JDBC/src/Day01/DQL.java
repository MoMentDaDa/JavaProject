package Day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class DQL {
	// ��ѯ����
	@Test
	public void test1() throws Exception {
		// ���ػ�ȡ�������ݿ����
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		// ����Statement�������ڴ���sql���
		Statement st = com.createStatement();
		// ����SQL���
		String sql = "SELECT COUNT(name) rows FROM t_student";
		ResultSet r = st.executeQuery(sql);
		if (r.next()) {
			long totalCount = r.getLong("rows");
			System.out.println(totalCount);
		}
		r.close();
		st.close();
		com.close();
	}

	@Test
	public void test2() throws Exception {
		// ����SQL���
		String sql = "SELECT * FROM t_student WHERE id=2";
		// �ֶ���ȡ���ݿ����
		Class.forName("com.mysql.jdbc.Driver");
		// ����jdbcdatabase���ݿ�
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		Thread.sleep(2000);
		// ����Statement�������ڴ���sql���
		Statement st = com.createStatement(); // ִ��SQL��ѯ���
		ResultSet r = st.executeQuery(sql);
		if (r.next()) {
			long totalCount = r.getLong("id");
			String name = r.getString("name");
			int age = r.getInt("age");
			System.out.println("name:" + name + ",age:" + age);
		}
		r.close();
		st.close();
		com.close();
	}
}
