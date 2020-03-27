package wang.CreatBean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import wang.CreatBean.way1.cat1;
import wang.CreatBean.way2.cat2;
import wang.CreatBean.way3.cat3;
import wang.CreatBean.way4.cat4;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	private cat1 c1;
	@Autowired
	private cat2 c2;
	@Autowired
	private cat3 c3;
	@Autowired
	private cat4 c4;

	@Test
	void test1() {
		// 传统的 Spring 方式，从IoC 中获取对象
		System.out.println(c1);
		
		// 静态工厂方法实例化,即通过类名调用静态方法获取对象
		// cat2 c2=cat2Factory.createInstance(); 传统方法
		System.out.println(c2);
		
		// 实例工厂方法，创建实例对象，通过方法返回获取对象
		// cat3 c3 = new Factory().createInstance();传统方法
		System.out.println(c3);// Spring 方法，通过插件方式获取
		
		System.out.println(c4);
	}
}
