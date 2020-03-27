package Anno.IoC;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	@Qualifier("xxds")
	private Person p1;

	@Test
	void test1() throws Exception {
		System.out.println(p1.toString());
	}
}
