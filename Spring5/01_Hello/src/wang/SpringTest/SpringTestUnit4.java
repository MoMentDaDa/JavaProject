package wang.SpringTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//运行Spring的jUnit4

@RunWith(SpringJUnit4ClassRunner.class)

//上下文配置对象(寻找配置文件的)
/* @ContextConfiguration("classpath:wang/SpringTest/SomeBean.xml") */
@ContextConfiguration
//@ContextConfiguration配置文件名应该为 当前测试类名-context.xml,即为 SpringTestUnit4-context.xml
public class SpringTestUnit4 {
	// 表示自动按照类型去Spring容器中找到bean对象,并设置给该字段
	@Autowired
	private SomeBean someBean;

	@Test
	public void test1() {
		someBean.dowork();
	}
}
