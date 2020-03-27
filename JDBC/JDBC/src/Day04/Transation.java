package Day04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import DoaPractice.util.SqlUntil;

public class Transation {
	private Connection com = SqlUntil.getcon();
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;

//δʹ���������
	@Test
	public void noTransation() {
		try {
			// ------------��ѯ����Ƿ����
			String sql = "SELECT * FROM transation WHERE name=? AND salary >=?";
			ps = com.prepareStatement(sql);
			ps.setString(1, "���޼�");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("����");
			}
			// -------------�������޼ɹ���1000
			sql = "UPDATE transation SET salary=salary-? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "���޼�");
			ps.executeUpdate();
			// ģ����;�ϵ����
			int a = 9 / 0;
			// ------------��������1000
			sql = "UPDATE transation SET salary=salary+? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "����");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}
	}

//ʹ���������
	@Test
	public void testByTransation() {
		try {
			com.setAutoCommit(false);// ���������ֶ��ύ
			// ------------��ѯ����Ƿ����
			String sql = "SELECT * FROM transation WHERE name=? AND salary >=?";
			ps = com.prepareStatement(sql);
			ps.setString(1, "���޼�");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("����");
			}
			// -------------�������޼ɹ���1000
			sql = "UPDATE transation SET salary=salary-? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "���޼�");
			ps.executeUpdate();
			// ------------��������1000
			// ģ����;�ϵ����
			int a = 9 / 0;
			sql = "UPDATE transation SET salary=salary+? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "����");
			ps.executeUpdate();
			com.commit();// �ύ������ͷ���Դ��
		} catch (SQLException e) {
			e.printStackTrace();
			// һ����������쳣��ʵ�ֻع���������֤���ݵ�ԭ����
			try {
				com.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			SqlUntil.close(com, ps, rs);

		}

	}

}
