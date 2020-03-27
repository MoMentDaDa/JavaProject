package JDBC_Apart.Test;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import JDBC_Apart.Dao.ResultUtil_Dao;
import JDBC_Apart.Impl.GeneralResultList;
import JDBC_Apart.Object.Mouse;
import JDBC_Apart.Util.JdbcTemplate;

//����̨�汾�ķ�ҳ��ѯ
public class PageTest {
	@Test
	public void test1() {
		// �û�����
		Integer currentPage = 1;// ��ǰ��Nҳ
		Integer pageSize = 3;// ÿҳ������������
		// ��ѯ�������
		String countSQL = "SELECT COUNT(*) FROM mouse";
		// Object[] params= {(currentPage-1)*pageSize)};
		Integer totalCount = JdbcTemplate.Query(countSQL, new ResultUtil_Dao<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);// ʹ�������ڲ��࣬ȡ�������һ�е�ֵ
				}
				return 0L;
			}
		}).intValue();
		System.out.println(totalCount);// ��ѯ�������
		// ��ѯ�����
		String resultSQL = "SELECT * FROM mouse LIMIT ?,?";
		Object[] params = { (currentPage - 1) * pageSize,pageSize };
		List<Mouse> listData = JdbcTemplate.Query(resultSQL, new GeneralResultList<>(Mouse.class), params);
		for (Mouse m : listData) {
			System.out.println(m.toString());
		}

	}

	class xx implements ResultUtil_Dao<Long> {

		@Override
		public Long handle(ResultSet rs) throws Exception {
			if (rs.next()) {
				return rs.getLong(1);// ȡ�������һ�е�ֵ
			}
			return 0L;
		}

	}
}
