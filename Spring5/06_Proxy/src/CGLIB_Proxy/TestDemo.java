package CGLIB_Proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import CGLIB_Proxy.Domain.Employee;
import CGLIB_Proxy.Service.EmployeeService;
import CGLIB_Proxy.tx.DynamicAgent;

@SpringJUnitConfig
class TestDemo {

	@Autowired
	private DynamicAgent agent;

	// JDK代理对象:com.sun.proxy.$Proxy19
	// CGLIB代理对象:class CGLIB_Proxy.Service.EmployeeService$$EnhancerByCGLIB$$506232ab

	@Test
	void testSave() throws Exception {
		Employee emp = new Employee();
		// 获取代理对象
		EmployeeService proxy = agent.getProxyObject();
		proxy.save(emp);
		System.out.println(proxy.getClass());

	}

	@Test
	void testUpdate() throws Exception {
		EmployeeService proxy = agent.getProxyObject();
		proxy.update(new Employee());
	}
}
