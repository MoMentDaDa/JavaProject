package JavaBean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorTestDemo {
	public static void main(String[] args) throws Exception {
		// 获取JavaBean的描述对象
		BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);// 设置获取字节码的上限，即到Object停止
		Person u = Person.class.newInstance();
		// 获取JavaBean中的属性描述器
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor ps : pds) {
			System.out.println("属性名:" + ps.getName());
			System.out.println("getter:" + ps.getReadMethod());
			System.out.println("setter:" + ps.getWriteMethod());
			System.out.println("-----------------------");
			if ("name".equals(ps.getName())) {
				Method setter = ps.getWriteMethod();
				setter.invoke(u, "will");

			}
		}
		System.out.println(u);
	}
}
