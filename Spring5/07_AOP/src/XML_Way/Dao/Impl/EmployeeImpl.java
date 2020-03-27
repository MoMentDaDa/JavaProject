package XML_Way.Dao.Impl;

import XML_Way.Dao.EmployeeDao;
import XML_Way.Domain.Employee;

public class EmployeeImpl implements EmployeeDao {
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
