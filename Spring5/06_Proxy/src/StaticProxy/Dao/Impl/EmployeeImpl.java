package StaticProxy.Dao.Impl;

import StaticProxy.Domain.Employee;

public class EmployeeImpl implements StaticProxy.Dao.EmployeeDao {
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
