package JDBC_Apart.Impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JDBC_Apart.Dao.ResultUtil_Dao;

/**
 * @ClassName: GeneralResultList
 * @Description: 多个结果集实现类
 * @author: 汪哒哒
 * @date: 2019年7月10日 上午10:37:12
 * @param <T>
 */
public class GeneralResultList<T> implements ResultUtil_Dao<List<T>> {
	private Class<T> ClassType;// 通用结果集的类型，处理多个结果，返回集合

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
				//System.out.println(pd.toString());
				// 获取对象属性名。属性名和列名必须相同，即数据库中的名字和类的属性名必须相同
				String columName = pd.getName();
				//System.out.println(columName);
				Object val = rs.getObject(columName);
				
				//System.out.println(obj.toString()+val);
				// 调用对象setter方法，将某一列数据设置进去
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return list;
	}
}
