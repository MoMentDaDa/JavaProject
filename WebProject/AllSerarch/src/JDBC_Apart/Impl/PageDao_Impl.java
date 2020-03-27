package JDBC_Apart.Impl;

import java.sql.ResultSet;

import JDBC_Apart.Dao.PageReslut_Dao;
import JDBC_Apart.Dao.ResultUtil_Dao;
import JDBC_Apart.Object.PageResult;
import JDBC_Apart.Util.JdbcTemplate;
import JDBC_Apart.adancedQuery.ProductQueryObject;

public class PageDao_Impl implements PageReslut_Dao {

	@Override
	public PageResult pageInfo(Integer currentpage, Integer pagesize, ProductQueryObject go) {
		// ��ѯ������������limit����
		String countSQL = "SELECT COUNT(*) FROM mouse" + go.getQuerySQL();
		Integer totalCount = JdbcTemplate.Query(countSQL, new ResultUtil_Dao<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);// ʹ�������ڲ��࣬ȡ�������һ�е�ֵ
				}
				return 0L;
			}
		}, go.getParameters().toArray()).intValue();
		return new PageResult(currentpage, pagesize, totalCount);
	}
}
