package ByAnno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ByAnno.Util.UserContext;
import ByAnno.dao.IEmployeeDAO;
import ByAnno.domain.Employee;
import ByAnno.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO dao;

	@Override
	@Transactional(readOnly = true)
	public Employee get(Long id) {
		return dao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> listAll() {
		return dao.listAll();
	}

	@Override
	public void save(Employee emp) {
		int a = 1 / 0;// 检验事务管理和统一异常处理是否生效
		dao.save(emp);

	}

	@Override
	public void update(Employee emp) {
		dao.update(emp);

	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public void login(String username, String password) {
		Employee current = dao.checkLogin(username, password);
		if (current == null) {
			throw new RuntimeException("账号或密码错误!");
		}
		UserContext.setCurrentUser(current);// 若没有问题，将登陆信息保存到session中。有问题则抛出异常

	}

}
