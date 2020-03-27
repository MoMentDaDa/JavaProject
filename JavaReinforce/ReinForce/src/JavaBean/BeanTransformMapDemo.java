package JavaBean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("all")
public class BeanTransformMapDemo {
	
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setId(1);
		p.setName("wang");
		p.setAge(19);

		Map m = new HashMap<String, Object>();
		m = beanTomp(p);
		System.out.println(m);
		System.out.println("-----------------------");
		
		Person p3 = mapTojavabean(m, Person.class);
		System.out.println(p3);
	}

	private static <T> T mapTojavabean(Map<String, Object> m, Class<T> beanType) throws Exception {
		T obj = beanType.newInstance();
		BeanInfo map = Introspector.getBeanInfo(beanType, Object.class);
		PropertyDescriptor[] pd = map.getPropertyDescriptors();
		for (PropertyDescriptor ps : pd) {
			Object value = m.get(ps.getName());
			System.out.println(value);
			ps.getWriteMethod().invoke(obj, value);
		}
		return obj;
	}

	private static Map<String, Object> beanTomp(Person p) throws Exception {
		Map map = new HashMap<String, Object>();
		BeanInfo info = Introspector.getBeanInfo(p.getClass(), Object.class);
		PropertyDescriptor[] pd = info.getPropertyDescriptors();
		for (PropertyDescriptor pd2 : pd) {
			String name = pd2.getName();
			Object value = pd2.getReadMethod().invoke(p);
			map.put(name, value);
		}
		return map;
	}
}
