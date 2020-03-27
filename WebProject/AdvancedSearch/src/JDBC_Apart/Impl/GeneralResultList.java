package JDBC_Apart.Impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JDBC_Apart.Dao.ResultUtil;

public class GeneralResultList<T> implements ResultUtil<List<T>> {
	private Class<T> ClassType;// ͨ�ý���������ͣ���������������ؼ���

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
				//System.out.println(pd.toString());
				// ��ȡ������������������������������ͬ�������ݿ��е����ֺ����������������ͬ
				String columName = pd.getName();
				//System.out.println(columName);
				Object val = rs.getObject(columName);
				
				//System.out.println(obj.toString()+val);
				// ���ö���setter��������ĳһ���������ý�ȥ
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return list;
	}
}
