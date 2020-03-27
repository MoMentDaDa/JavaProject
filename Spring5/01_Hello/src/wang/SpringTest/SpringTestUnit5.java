package wang.SpringTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//运行 Spring 的JUint5
@SpringJUnitConfig
public class SpringTestUnit5 {

	@Autowired
	private SomeBean bean;

	@Test
	void test1() throws Exception {
		bean.dowork();
	}
}
