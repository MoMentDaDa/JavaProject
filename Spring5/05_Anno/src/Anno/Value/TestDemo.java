package Anno.Value;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	private port p1;

	@Test
	void test1() throws Exception {
		System.out.println(p1.toString());
	}
}
