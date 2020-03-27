package Anno_Way;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import Anno_Way.Domain.Employee;
import Anno_Way.Service.EmployeeServiceDao;

@SpringJUnitConfig
class TestDemo {

	@Autowired
	private EmployeeServiceDao service;

	@Test
	void testSave() throws Exception {
		System.out.println(service.getClass());//查看对象的真实类型
		service.save(new Employee());
	}

	@Test
	void testUpdate() throws Exception {
		service.update(new Employee());
	}
}
