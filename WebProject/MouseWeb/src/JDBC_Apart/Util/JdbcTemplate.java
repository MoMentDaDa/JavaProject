package JDBC_Apart.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.ResultUtil;



public class JdbcTemplate {
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
			//ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// �����ǵڼ�����������ռλ����ֵ
				ps.setObject(index + 1, params[index]);
				// ִ����䣬��������
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// SqlUntil.close(com, ps, null);
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
	public static <T> T Query(String sql, ResultUtil<T> rsh, Object... params) {
		try {
			//ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// �����ǵڼ�����������ռλ����ֵ
				ps.setObject(index + 1, params[index]);
			}
			// �����ؽ����
			return rsh.handle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// SqlUntil.close(com, ps, rs);
		}
		throw new RuntimeException("��ѯ����");
	}
}
