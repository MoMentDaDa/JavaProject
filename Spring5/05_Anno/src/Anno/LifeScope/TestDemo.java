package Anno.LifeScope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	private Mechine p1;
	
	@Autowired
	private Mechine p2;


	@Test
	void test1() throws Exception {
		p1.doWork();
		System.out.println(p1);
		System.out.println(p2);
	}
}
