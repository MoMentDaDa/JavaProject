package SetterDi_02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import SetterDi_02.Collection.CollectionBean;
import SetterDi_02.Constant.Employee;
import SetterDi_02.Object.Person1;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	Employee employee;

	@Autowired
	Person1 person;
	
	@Autowired
	CollectionBean c1;

	@Test
	void test() {
		System.out.println(employee.toString());
		System.out.println(person.toString());
		System.out.println(c1.toString());
	}

}
