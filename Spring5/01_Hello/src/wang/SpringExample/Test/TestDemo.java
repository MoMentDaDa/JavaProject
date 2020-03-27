package wang.SpringExample.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import wang.SpringExample.Domain.Employee;

public class TestDemo {
	@Test
	public void testOld() throws Exception {
		Employee world = new Employee();
		world.setUsername("will");
		world.setAge(17);
		world.sayHello();
	}

	@Test
	public void testBySpring() throws Exception {
		Employee world = null;
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//第一种签名：根据 bean 对象从容器中获取一个 Objecct 对象
		//world = (Employee) factory.getBean("employee");
		
		//第一种签名：按照指定的类型去寻找对象
		//world =factory.getBean(Employee.class);
		
		//按照名字和类型:(推荐) 
		world = factory.getBean("employee",Employee.class);
		world.sayHello();
	}

	// 模拟 IoC 容器操作
	@Test
	public void testIoCMock() throws Exception, Throwable {
		Employee employee = null;
		// 使用反射创建对象
		String className = "com.wang.Domain.Employee";
		Class clzz = Class.forName(className);
		Constructor con = clzz.getConstructor();
		con.setAccessible(true);
		Object obj = con.newInstance();
		// 使用内省机制设置属性值
		BeanInfo beanInfo = Introspector.getBeanInfo(clzz, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			// employee 类中的属性名称
			String propertyName = pd.getName();
			if ("username".equals(propertyName)) {
				// 调用set 方法设值
				pd.getWriteMethod().invoke(obj, "Lucy");
			} else if ("age".equals(propertyName)) {
				pd.getWriteMethod().invoke(obj, 17);
			}
		}
		employee = (Employee) obj;
		employee.sayHello();

	}

}
