package XmlAutowire_01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
@SpringJUnitConfig
class TestDemo {
	@Autowired
	Person person;

	@Test
	void test() {
		System.out.println(person.toString());
	}

}
