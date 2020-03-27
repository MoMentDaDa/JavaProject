package ByXML.service.impl;

import java.util.List;

import ByXML.dao.IEmployeeDAO;
import ByXML.domain.Employee;
import ByXML.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDAO dao;

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}

	public void save(Employee emp) {
		int a = 1 / 0;// 检验事务管理和统一异常处理是否生效
		dao.save(emp);
	}

	public void update(Employee emp) {
		dao.update(emp);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public Employee get(Long id) {
		return dao.get(id);
	}

	public List<Employee> listAll() {
		System.out.println("this is by XML");
		return dao.listAll();
	}

	public Employee login(String username, String password) {
		return dao.checkLogin(username, password);
	}

}
