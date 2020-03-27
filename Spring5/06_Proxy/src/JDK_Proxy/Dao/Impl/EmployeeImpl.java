package JDK_Proxy.Dao.Impl;

import JDK_Proxy.Dao.EmployeeDao;
import JDK_Proxy.Domain.Employee;

public class EmployeeImpl implements EmployeeDao {
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
