package Day05.Impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneralResultList<T> implements ResultUtil<List<T>> {
	private Class<T> ClassType;// 通用结果集的类型

	public GeneralResultList(Class<T> calsstype) {
		this.ClassType = calsstype;
	}

	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while (rs.next()) {
			// 创建一个对应类对象
			T obj = ClassType.newInstance();
			// 取出结果集中当前光标所在的某一列的数据
			list.add(obj);
			BeanInfo bf = Introspector.getBeanInfo(ClassType, Object.class);
			PropertyDescriptor[] pds = bf.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				// 获取对象属性名。属性名和列名相同
				String columName = pd.getName();
				Object val = rs.getObject(columName);
				// 调用对象setter方法，将某一列数据设置进去
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return list;
	}
}
