package Day04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import DoaPractice.util.SqlUntil;

public class BatAction {
	private PreparedStatement ps = null;
	private Statement st = null;
	private Connection com = SqlUntil.getcon();

//ʹ��statment���Բ������
//InnoDB 3582
//MyISAM  938
	@Test
	public void testByStatment() throws Exception {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 3000; i++) {
			String sql = "INSERT INTO newtable (name,age) VALUES ('AA',12)";
			st = com.createStatement();
			st.executeUpdate(sql);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

//ʹ��statment���������������
//InnoDB 3988
//MyISAM  930
	@Test
	public void testByStatmentBat() throws Exception {
		long begin = System.currentTimeMillis();
		String sql = "INSERT INTO newtable (name,age) VALUES ('AA',12)";
		st = com.createStatement();
		for (int i = 1; i < 3001; i++) {
			st.addBatch(sql);
			if (i % 500 == 0) {
				st.executeBatch();
				st.clearBatch();
			}
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

//ʹ��PreparedStatement���Բ������
//InnoDB 3949
//MyISAM  1047
	@Test
	public void testByPreparedStatement() throws Exception {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 3000; i++) {
			String sql = "INSERT INTO newtable (name,age) VALUES ('AA',12)";
			ps = com.prepareStatement(sql);
			ps.executeUpdate(sql);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

// ʹ��PreparedStatement���Բ������
// InnoDB 3050
// MyISAM 655
	@Test
	public void testByPreparedStatementBat() throws Exception {
		long begin = System.currentTimeMillis();
		String sql = "INSERT INTO newtable (name,age) VALUES ('AA',12)";
		ps = com.prepareStatement(sql);
		for (int i = 0; i < 3000; i++) {
			ps.addBatch();
			if (i % 500 == 0) {
				ps.executeBatch();
				ps.clearBatch();
			}
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

//�Զ���������
	@Test
	public void AutoGetIdByStatement() throws Exception {
		String sql = "INSERT INTO newtable (name,age) VALUES ('AA',12)";
		st = com.createStatement();
		for (int i = 0; i < 10; i++) {
			// ������������
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		}
		ResultSet rs = st.getGeneratedKeys();// ��ȡ�Զ���������
		if (rs.next()) {
			Long id = rs.getLong(1);
			System.out.println(id);
		}

	}
}
