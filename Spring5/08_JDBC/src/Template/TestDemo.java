package Template;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import Template.Dao.EmployeeDao;
import Template.Domain.Employee;

@SpringJUnitConfig
class TestDemo {
	@Autowired
	private EmployeeDao dao;

	@Test
	public void test() throws SQLException {
		Employee emp = new Employee();
		emp.setName("黑寡妇");
		emp.setAge(30);
		dao.save(emp);
	}

	@Test
	void test2() throws Exception {
		Employee emp = new Employee();
		emp.setName("黑寡妇");
		emp.setAge(31);
		dao.update(emp, 10L);

	}

	@Test
	void test3() throws Exception {
		dao.delete(11L);

	}

	@Test
	void test4() throws Exception {
		List<Employee> list = dao.listAll();
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	@Test
	void testGet() throws Exception {
		Employee e = dao.get(8L);
		System.out.println(e);
	}

}
