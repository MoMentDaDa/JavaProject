package Day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DDL {
	// ����t_student��
	@Test
	public void test1() throws Exception {
		String sql = "CREATE TABLE `t_student2`(`id` BIGINT,`name` VARCHAR(20),`email` VARCHAR(20),`age`  INT);";
		// ���ػ�ȡ�������ݿ����
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		// ����Statement�������ڴ���sql���
		Statement st = com.createStatement();
		// 3��ִ��SQL���
		int row = st.executeUpdate(sql);
		st.close();
		com.close();
		System.out.println(row);
	}

//�����������
	@Test
	public void test2() throws Exception {
		String sql="insert into t_student(id,name,age) VAlUES(1,'�Ƿ�',30)";
		String sql2="insert into t_student(id,name,age) VAlUES(2,'���Ŵ�ѩ',10)";
		String sql3="DELETE FROM t_student WHERE id=1";
		// ���ػ�ȡ�������ݿ����
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		// ����Statement�������ڴ���sql���
		Statement st = com.createStatement();
		Statement st2 = com.createStatement();
		// 3��ִ��SQL���
		int row = st.executeUpdate(sql3);
		st.close();
		com.close();
		System.out.println(row);
	}
}
