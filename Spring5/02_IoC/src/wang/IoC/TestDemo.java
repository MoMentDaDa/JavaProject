package wang.IoC;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestDemo {

	@Autowired
	private SomeBean bean;
 
	@Test
	void test1() throws Exception {
		bean.dowork();
	}

	// 基于BeanFactory 的实现方式
	@Test
	public void test2() throws Exception {
		Resource resource = new ClassPathResource("wang/SpringTest/SomeBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("--------before --------");
		SomeBean p = factory.getBean("SomeBean", SomeBean.class);
		System.out.println("--------after --------");
		System.out.println(p);
	}

	// 基于ApplicationContext 的实现方式
	@Test
	public void test3() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("wang/SpringTest/SomeBean.xml");
		System.out.println("--------before --------");
		SomeBean p = ctx.getBean("SomeBean", SomeBean.class);
		System.out.println("--------after --------");
		System.out.println(p);

	}
}
