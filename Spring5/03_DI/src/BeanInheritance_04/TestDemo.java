package BeanInheritance_04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	SomeBean SomeBean;

	@Autowired
	SomeBean2 SomeBean2;

	@Test
	void test() {
		System.out.println(SomeBean.toString());
		System.out.println(SomeBean2.toString());
	}

}
