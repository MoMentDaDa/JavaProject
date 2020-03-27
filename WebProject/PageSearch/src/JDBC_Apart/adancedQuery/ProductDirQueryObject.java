package JDBC_Apart.adancedQuery;

import org.apache.commons.lang3.StringUtils;

public class ProductDirQueryObject extends AdancedQueryObject{
	private int id;
private String dirName;
//���Ʒ����ѯ
	@Override
	protected void customizedQuery() {
		//��������
		if(StringUtils.isNotBlank(dirName)) {
			super.addQuery("dirName LIKE ?", "%"+dirName+"%");
		}
	}

}
