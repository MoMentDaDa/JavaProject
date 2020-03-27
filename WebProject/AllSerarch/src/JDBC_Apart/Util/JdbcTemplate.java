package JDBC_Apart.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import JDBC_Apart.Dao.ResultUtil_Dao;
import JDBC_Apart.Object.Mouse;

public class JdbcTemplate {
	static DataSource2 pool = new DataSource2();
	static Connection com = null;
	static PreparedStatement st = null;
	static List<Mouse> list = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static int row;

	/**
	 * O DML��������ɾ�ģ�ģ��
	 * 
	 * @param sql    DML������SQLģ�壨����ռλ����
	 * @param params SQLģ���У���Ӧ�Ĳ���ֵ
	 * @return ����
	 */
	public static int Update(String sql, Object... params) {
		try {
			com = pool.getConnection();
			ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// �����ǵڼ�����������ռλ����ֵ
				ps.setObject(index + 1, params[index]);
				// ִ����䣬��������
			}
			//System.out.println(ps.toString());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	private static void isNull(Object[] val, Mouse oldm) {

	}

//�ж�ֵ�Ƿ���ͬ

	/**
	 * DML ����ģ��
	 * 
	 * @param sql    �����SQL���
	 * @param params SQL��ռλ��
	 * @return ���ز�ѯ��List�����
	 */
	public static <T> T Query(String sql, ResultUtil_Dao<T> rsh, Object... params) {
		try {
			com = pool.getConnection();
			ps = com.prepareStatement(sql);
			// System.out.println(ps.toString());
			// System.out.println(params.length);0
			if (params.length != 0) {
				for (int index = 0; index < params.length; index++) {
					// �����ǵڼ�����������ռλ����ֵ
					ps.setObject(index + 1, params[index]);
				}
			}
			//System.out.println(ps.toString());
			// �����ؽ����
			return rsh.handle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("��ѯ����");
	}
}
