package JDBC_Apart.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import JDBC_Apart.Dao.I_pageDao;
import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.PageResult;
import JDBC_Apart.Dao.ResultUtil;
import JDBC_Apart.Util.JdbcTemplate;
import JDBC_Apart.adancedQuery.ProductQueryObject;

public class PageDao_Impl implements I_pageDao {

	private Object[] params;
	private List<Object> result;

	@Override
	public List<Mouse> list() {
		String sql = "SELECT * FROM mouse";
		return JdbcTemplate.Query(sql, new GeneralResultList<>(Mouse.class));
	}

	@Override
	public List<Mouse> query(ProductQueryObject go) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List query(Integer currentPage, Integer pageSize) {
		// 查询结果总数
		String countSQL = "SELECT COUNT(*) FROM mouse";
		Integer totalCount = JdbcTemplate.Query(countSQL, new ResultUtil<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);// 使用匿名内部类，取结果集第一列的值
				}
				return 0L;
			}
		}).intValue();
		/*
		 * if (totalCount == 0) {// 说明没有符合条件的数据，即没必要查询结果集 return
		 * PageResult.empty(pageSize); }
		 */
		// 查询结果集
		String resuleSQL = "SELECT * FROM mouse LIMIT ?,?";
		PageResult pageRes = new PageResult(currentPage, pageSize, totalCount);
		params = new Object[] { (pageRes.getCurrentPage() - 1) * pageRes.getPageSize(), pageRes.getPageSize() };
		List<Mouse> listData = JdbcTemplate.Query(resuleSQL, new GeneralResultList<>(Mouse.class), params);
		result = new ArrayList<Object>();
		result.add(pageRes);
		result.add(listData);
		//System.out.println(result.size());
		return result;
	}
}
