package Day01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTestDemo {
	@Test
	public void test1() throws Exception {
		// �ֶ���ȡ���ݿ����
		Class.forName("com.mysql.jdbc.Driver");
		// ����jdbcdatabase���ݿ�
		Connection com =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		Thread.sleep(20000);
	}
	@Test
	public void test2() throws Exception {
		// Java1.6��ʼ֧���Զ���ȡ���ݿ��������jdbcdatabase���ݿ�
		Connection com =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase", "root", "admin");
		Thread.sleep(10000);
	}
}
