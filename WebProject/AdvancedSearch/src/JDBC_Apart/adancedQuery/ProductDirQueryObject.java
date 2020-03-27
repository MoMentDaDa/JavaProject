package JDBC_Apart.adancedQuery;

import org.apache.commons.lang3.StringUtils;

public class ProductDirQueryObject extends AdancedQueryObject{
	private int id;
private String dirName;
//定制分类查询
	@Override
	protected void customizedQuery() {
		//分类名称
		if(StringUtils.isNotBlank(dirName)) {
			super.addQuery("dirName LIKE ?", "%"+dirName+"%");
		}
	}

}
