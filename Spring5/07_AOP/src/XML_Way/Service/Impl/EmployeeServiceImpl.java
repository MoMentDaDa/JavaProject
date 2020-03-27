package XML_Way.Service.Impl;

import XML_Way.Dao.EmployeeDao;
import XML_Way.Domain.Employee;
import XML_Way.Service.EmployeeServiceDao;

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
