package wang.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	private MyDataSource My;

	// 传统初始化方式
	@Test
	void testOld() {
		// 创建对象
		MyDataSource da = new MyDataSource();
		// 对对象进行初始化操作
		da.open();
		// 执行工作
		da.doWork();
		// 销毁工作对象
		da.close();
	}

	// 使用 Spring 框架管理对象信息，初始化和销毁
	@Test
	void testNew() {
		My.doWork();
	}

	// 使用 ApplicationContext 框架管理对象信息，销毁需要手动关闭,或者直接贴注解
	@Test
	void testByapplicationContext() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("wang/lifeCycle/TestDemo-context.xml");
		MyDataSource bean = ctx.getBean("dataSource", MyDataSource.class);
		bean.doWork();
		bean.close();
	}
}
