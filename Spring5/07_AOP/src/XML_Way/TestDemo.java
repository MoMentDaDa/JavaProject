package XML_Way;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import XML_Way.Domain.Employee;
import XML_Way.Service.EmployeeServiceDao;

@SpringJUnitConfig
class TestDemo {

	@Autowired
	private EmployeeServiceDao proxy;

	@Test
	void testSave() throws Exception {
		Employee emp=new Employee();
		System.out.println(proxy.getClass());
		proxy.save(emp);

	}

	@Test
	void testUpdate() throws Exception {
	
		proxy.update(new Employee());
	}
}
