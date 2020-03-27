package JDBC_Apart.Impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class GeneralResult<T> implements ResultUtil<T> {
	private Class<T> ClassType;// 通用结果集的类型

	public GeneralResult(Class<T> calsstype) {
		this.ClassType = calsstype;
	}

	@Override
	public T handle(ResultSet rs) throws Exception {
		// 创建一个对应类对象
		T obj = ClassType.newInstance();
		// 取出结果集中当前光标所在的某一列的数据
		BeanInfo bf = Introspector.getBeanInfo(ClassType, Object.class);
		PropertyDescriptor[] pds = bf.getPropertyDescriptors();
		if (rs.next()) {
			for (PropertyDescriptor pd : pds) {
				// 获取对象属性名。属性名和列名相同
				String columName = pd.getName();
				Object val = rs.getObject(columName);
				// System.out.println(columName + val);
				// 调用对象setter方法，将某一列数据设置进去
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return obj;
	}

}
