package JDBC_Apart.Test;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import JDBC_Apart.Dao.ResultUtil_Dao;
import JDBC_Apart.Impl.GeneralResultList;
import JDBC_Apart.Object.Mouse;
import JDBC_Apart.Util.JdbcTemplate;

//控制台版本的分页查询
public class PageTest {
	@Test
	public void test1() {
		// 用户传入
		Integer currentPage = 1;// 当前第N页
		Integer pageSize = 3;// 每页最多多少条数据
		// 查询结果总数
		String countSQL = "SELECT COUNT(*) FROM mouse";
		// Object[] params= {(currentPage-1)*pageSize)};
		Integer totalCount = JdbcTemplate.Query(countSQL, new ResultUtil_Dao<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);// 使用匿名内部类，取结果集第一列的值
				}
				return 0L;
			}
		}).intValue();
		System.out.println(totalCount);// 查询结果总数
		// 查询结果集
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
				return rs.getLong(1);// 取结果集第一列的值
			}
			return 0L;
		}

	}
}
