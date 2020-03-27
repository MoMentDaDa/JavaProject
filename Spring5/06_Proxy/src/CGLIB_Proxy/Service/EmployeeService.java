package CGLIB_Proxy.Service;

import CGLIB_Proxy.Dao.EmployeeDao;
import CGLIB_Proxy.Domain.Employee;

public class EmployeeService {

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
