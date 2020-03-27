package StaticProxy.Service.Impl;

import StaticProxy.Dao.EmployeeDao;
import StaticProxy.Domain.Employee;
import StaticProxy.Service.EmployeeServiceDao;

public class EmployeeServiceImpl implements EmployeeServiceDao {
	private EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	public void save(Employee emp) {
		dao.save(emp);
		System.out.println("保存成功");
	}

	public void update(Employee emp) {
		dao.update(emp);
		throw new RuntimeException("故意错误的");
	}
}
