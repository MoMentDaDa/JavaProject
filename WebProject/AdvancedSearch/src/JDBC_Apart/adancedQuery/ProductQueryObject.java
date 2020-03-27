package JDBC_Apart.adancedQuery;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

//封装商品对象的查询条件
@Setter
@Getter
public class ProductQueryObject extends AdancedQueryObject {
	private String name;
	private String maxPrice;
	private String minPrice;
	private int dirId = -1;
	private String keyWord;

	// 自身定制查询
	@Override
	protected void customizedQuery() {
		// 商品名称
		if (StringUtils.isNotBlank(name)) {
			super.addQuery(" name LIKE ?", "%" + name + "%");
		}
		// 最低价
		if (minPrice != null) {
			super.addQuery("price>=?", minPrice);
		}
		// 最高价
		if (maxPrice != null) {
			super.addQuery("price<=?", maxPrice);
		}
		// 商品分类
		if (dirId != -1) {
			super.addQuery("classiFication=?", dirId);
		}
		// 关键字
		if (StringUtils.isNoneBlank(keyWord)) {
			super.addQuery("(name LIKE ? or wire LIKE ?)", "%" + keyWord + "%", "%" + keyWord + "%");
		}

	}
}
