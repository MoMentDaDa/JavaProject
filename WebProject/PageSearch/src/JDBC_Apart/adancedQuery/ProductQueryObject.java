package JDBC_Apart.adancedQuery;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

//��װ��Ʒ����Ĳ�ѯ����
@Setter
@Getter
public class ProductQueryObject extends AdancedQueryObject {
	private String name;
	private String maxPrice;
	private String minPrice;
	private int dirId = -1;
	private String keyWord;

	// �����Ʋ�ѯ
	@Override
	protected void customizedQuery() {
		// ��Ʒ����
		if (StringUtils.isNotBlank(name)) {
			super.addQuery(" name LIKE ?", "%" + name + "%");
		}
		// ��ͼ�
		if (minPrice != null) {
			super.addQuery("price>=?", minPrice);
		}
		// ��߼�
		if (maxPrice != null) {
			super.addQuery("price<=?", maxPrice);
		}
		// ��Ʒ����
		if (dirId != -1) {
			super.addQuery("classiFication=?", dirId);
		}
		// �ؼ���
		if (StringUtils.isNoneBlank(keyWord)) {
			super.addQuery("(name LIKE ? or wire LIKE ?)", "%" + keyWord + "%", "%" + keyWord + "%");
		}

	}
}
