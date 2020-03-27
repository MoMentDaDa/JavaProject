package JDBC_Apart.adancedQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

//�߼���ѯ����Ļ��࣬�������в�ѯ����Ĺ���
public class AdancedQueryObject {
	// ��װ��ѯ����
	private List<String> condition = new ArrayList<>();// �������������ڴ�Ų�ѯ����
	private List<Object> parameters = new ArrayList<>();// ���ڷ�װռλ������

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

//��¶�����࣬�������д��������Ĳ�ѯ��ʽ
	protected void customizedQuery() {
	}

//���ز�ѯ������ռλ������ֵ
	public List<Object> getParameters() {
		// this.init();
		return parameters;
	}

	// ���ز�ѯ��ռλ�����
	public List<String> getCondition() {
		return condition;
	}

	// ��¶�����࣬��������customizedQuery�е��ã�����Լ��Ĳ�ѯ�����Ͳ���
	protected void addQuery(String condition, Object... params) {
		this.condition.add(condition);
		this.parameters.addAll(Arrays.asList(params));

	}
}
