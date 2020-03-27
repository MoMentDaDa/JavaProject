package JDK_Proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import JDK_Proxy.Dao.EmployeeDao;
import JDK_Proxy.Domain.Employee;
import JDK_Proxy.Service.EmployeeServiceDao;
import JDK_Proxy.Service.Impl.EmployeeServiceImpl;
import JDK_Proxy.tx.DynamicAgent;

@SpringJUnitConfig
class TestDemo {

	@Autowired
	private DynamicAgent agent;

	@Test
	void testSave() throws Exception {
		Employee emp=new Employee();
		// 获取代理对象
		EmployeeServiceDao proxy = agent.getProxyObject();
		//services.save(new Employee());
		proxy.save(emp);

	}

	@Test
	void testUpdate() throws Exception {
		EmployeeServiceDao services = agent.getProxyObject();
	
		services.update(new Employee());
	}
}
