package JDBC_Apart.adancedQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

//高级查询对象的基类，包含所有查询对象的共性
public class AdancedQueryObject {
	// 封装查询条件
	private List<String> condition = new ArrayList<>();// 当作容器，用于存放查询条件
	private List<Object> parameters = new ArrayList<>();// 用于封装占位符参数

	public String getQuerySQL() {
		StringBuilder sql = new StringBuilder(80);
		this.condition.clear();
		this.parameters.clear();
		this.customizedQuery();
		if (condition.size() == 0) {
			return "";
		}
		String queryString = StringUtils.join(condition, " AND ");
		return sql.append(" WHERE ").append(queryString).toString();

	}

//暴露给子类，让子类编写符合自身的查询方式
	protected void customizedQuery() {
	}

//返回查询条件的占位符参数值
	public List<Object> getParameters() {
		// this.init();
		return parameters;
	}

	// 返回查询的占位符语句
	public List<String> getCondition() {
		return condition;
	}

	// 暴露给子类，让子类在customizedQuery中调用，添加自己的查询条件和参数
	protected void addQuery(String condition, Object... params) {
		this.condition.add(condition);
		this.parameters.addAll(Arrays.asList(params));

	}
}
