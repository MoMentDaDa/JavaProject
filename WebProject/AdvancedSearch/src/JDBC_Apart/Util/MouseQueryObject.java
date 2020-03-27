package JDBC_Apart.Util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: ProductQueryObject
 * @Description: ���ڷ�װ�����Ķ����,������ SQL �������
 * @author: ������
 * @date: 2019��6��25�� ����5:44:33
 */
@Setter
@Getter
public class MouseQueryObject {
	private String name;
	private String maxPrice;// ʵ�����Կ�ͷ����ȫ��Сд������ǰ�˻�ȡ���������Ҫ������дһ���������ڻ�ȡ��д��ͷ������
	private String minPrice;
	private int dirId = -1;
	// �������������ڴ�Ų�ѯ����
	private List<String> condition = new ArrayList<>();
	// ���ڷ�װռλ������
	private List<Object> parameters = new ArrayList<>();
	public String getQuerySQL() {
		StringBuilder sql = new StringBuilder(80);
		// ��Ʒ����
		if (StringUtils.isNotBlank(name)) {
			condition.add("name LIKE ?");
			parameters.add("%" + name + "%");
		}
		// ��߼۸�
		if (StringUtils.isNotBlank(maxPrice)) {
			condition.add("price<=?");
			parameters.add(maxPrice);
		}
		// ��ͼ۸�
		if (StringUtils.isNotBlank(minPrice)) {
			condition.add("price>=?");
			parameters.add(minPrice);
		}
		// ��Ʒ����
		if (dirId != -1) {
			condition.add("classiFication=?");
			parameters.add(dirId);
		}
		if (condition.size() == 0) {
			return "";
		}
		// �������ȼ��� for����
		// String queryString = StringUtils.join(condition, " AND ");
		// System.out.println(sql.append(" WHERE ").append(queryString.toString()));

		// ����ƴ��SQL���
		for (int i = 0; i < condition.size(); i++) {
			if (i == 0) {// ��һ������
				sql.append(" WHERE ");
			} else {// �ǵ�һ������
				sql.append(" AND ");
			}
			sql.append(condition.get(i));
		}
		System.out.println("����ƴ��SQL�Ĳ�����䣺" + condition.toString());
		System.out.println("���ص��Ѿ�ƴ�Ӻõ�β��SQL��" + sql.toString());
		System.out.println("���ڲ�ѯ�Ĳ�����" + parameters.toString());
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
