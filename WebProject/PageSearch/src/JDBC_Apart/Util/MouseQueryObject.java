package JDBC_Apart.Util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: ProductQueryObject
 * @Description: 用于封装参数的对象等,即返回 SQL 后半截语句
 * @author: 汪哒哒
 * @date: 2019年6月25日 下午5:44:33
 */
@Setter
@Getter
public class MouseQueryObject {
	private String name;
	private String maxPrice;// 实体属性开头必须全部小写，否则前端获取会产生错误，要不就另写一个方法用于获取大写开头的属性
	private String minPrice;
	private int dirId = -1;
	// 当作容器，用于存放查询条件
	private List<String> condition = new ArrayList<>();
	// 用于封装占位符参数
	private List<Object> parameters = new ArrayList<>();
	public String getQuerySQL() {
		StringBuilder sql = new StringBuilder(80);
		// 商品名称
		if (StringUtils.isNotBlank(name)) {
			condition.add("name LIKE ?");
			parameters.add("%" + name + "%");
		}
		// 最高价格
		if (StringUtils.isNotBlank(maxPrice)) {
			condition.add("price<=?");
			parameters.add(maxPrice);
		}
		// 最低价格
		if (StringUtils.isNotBlank(minPrice)) {
			condition.add("price>=?");
			parameters.add(minPrice);
		}
		// 商品分类
		if (dirId != -1) {
			condition.add("classiFication=?");
			parameters.add(dirId);
		}
		if (condition.size() == 0) {
			return "";
		}
		// 下面语句等价于 for语句段
		// String queryString = StringUtils.join(condition, " AND ");
		// System.out.println(sql.append(" WHERE ").append(queryString.toString()));

		// 用于拼接SQL语句
		for (int i = 0; i < condition.size(); i++) {
			if (i == 0) {// 第一个条件
				sql.append(" WHERE ");
			} else {// 非第一个条件
				sql.append(" AND ");
			}
			sql.append(condition.get(i));
		}
		System.out.println("用于拼接SQL的部分语句：" + condition.toString());
		System.out.println("返回的已经拼接好的尾部SQL：" + sql.toString());
		System.out.println("用于查询的参数：" + parameters.toString());
		return sql.toString();
	}

	public List<Object> getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "ProductQueryObject [name=" + name + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", dirId="
				+ dirId + ", condition=" + condition + ", parameters=" + parameters + "]";
	}
}
