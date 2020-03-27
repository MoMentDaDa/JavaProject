package LogUtil.Dao.Impl;

import LogUtil.Dao.EmployeeDao;
import LogUtil.Domain.Employee;

public class EmployeeImpl implements EmployeeDao{
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
