package CGLIB_Proxy.Dao.Impl;

import CGLIB_Proxy.Dao.EmployeeDao;
import CGLIB_Proxy.Domain.Employee;

public class EmployeeImpl implements EmployeeDao{
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
