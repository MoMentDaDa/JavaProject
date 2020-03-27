package LogUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import LogUtil.Dao.EmployeeDao;
import LogUtil.Domain.Employee;
import LogUtil.Log.LogAdvanced;
import LogUtil.Service.EmployeeServiceImpl;

@SpringJUnitConfig

class TestDemo {
	
	@Autowired
	private LogAdvanced agent;

	@Test
	void testSave() throws Exception {
		Employee emp = new Employee();
		// 获取代理对象
		EmployeeServiceImpl proxy = agent.getProxyObject();
		proxy.save(emp);

	}

	@Test
	void testUpdate() throws Exception {
		Employee emp = new Employee();
		// 获取代理对象
		EmployeeServiceImpl proxy = agent.getProxyObject();

		proxy.update(new Employee());
	}
}
