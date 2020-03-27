package JDBC_Apart.Impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class GeneralResult<T> implements ResultUtil<T> {
	private Class<T> ClassType;// ͨ�ý����������

	public GeneralResult(Class<T> calsstype) {
		this.ClassType = calsstype;
	}

	@Override
	public T handle(ResultSet rs) throws Exception {
		// ����һ����Ӧ�����
		T obj = ClassType.newInstance();
		// ȡ��������е�ǰ������ڵ�ĳһ�е�����
		BeanInfo bf = Introspector.getBeanInfo(ClassType, Object.class);
		PropertyDescriptor[] pds = bf.getPropertyDescriptors();
		if (rs.next()) {
			for (PropertyDescriptor pd : pds) {
				// ��ȡ��������������������������ͬ
				String columName = pd.getName();
				Object val = rs.getObject(columName);
				// System.out.println(columName + val);
				// ���ö���setter��������ĳһ���������ý�ȥ
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return obj;
	}

}
