package ConstructorDi_03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ConstructorDi_03.Constant.Employee;
import ConstructorDi_03.Object.Person1;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	Employee employee;

	@Autowired
	Person1 person;

	@Autowired
	ConstructorDi_03.Collection.CollectionBean coll;

	@Test
	void test() {
		System.out.println(employee.toString());
		System.out.println(person.toString());
		System.out.println(coll.toString());
	}

}
