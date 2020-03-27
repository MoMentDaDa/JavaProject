package Day05.Impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneralResultList<T> implements ResultUtil<List<T>> {
	private Class<T> ClassType;// ͨ�ý����������

	public GeneralResultList(Class<T> calsstype) {
		this.ClassType = calsstype;
	}

	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while (rs.next()) {
			// ����һ����Ӧ�����
			T obj = ClassType.newInstance();
			// ȡ��������е�ǰ������ڵ�ĳһ�е�����
			list.add(obj);
			BeanInfo bf = Introspector.getBeanInfo(ClassType, Object.class);
			PropertyDescriptor[] pds = bf.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				// ��ȡ��������������������������ͬ
				String columName = pd.getName();
				Object val = rs.getObject(columName);
				// ���ö���setter��������ĳһ���������ý�ȥ
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return list;
	}
}
