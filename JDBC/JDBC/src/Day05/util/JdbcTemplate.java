package Day05.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Day05.DaoMain.Student;
import Day05.Impl.ResultImpl;
import Day05.Impl.ResultUtil;

public class JdbcTemplate {
	static Connection com = Day05.util.SqlUntil.getcon();
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static List<Student> list = new ArrayList();
	static int row;

	/**
	 * DML��������ɾ�ģ�ģ��
	 * 
	 * @param sql    DML������SQLģ�壨����ռλ����
	 * @param params SQLģ���У���Ӧ�Ĳ���ֵ
	 * @return ����
	 */
	public static int Update(String sql, Object... params) {
		try {
			ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {

				// �����ǵڼ�����������ռλ����ֵ
				ps.setObject(index + 1, params[index]);
				// ִ����䣬��������
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, null);
		}
		return 0;
	}

	/**
	 * DML ����ģ��
	 * 
	 * @param sql    �����SQL���
	 * @param params SQL��ռλ��
	 * @return ���ز�ѯ��List�����
	 */
	public static <T>T Query(String sql, ResultUtil<T> rsh, Object... params) {
		try {
			ps = com.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				// �����ǵڼ�����������ռλ����ֵ
				ps.setObject(index + 1, params[index]);
			}
			// �����ؽ����
			return rsh.handle(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}
		throw new RuntimeException("��ѯ����");
	}
}
