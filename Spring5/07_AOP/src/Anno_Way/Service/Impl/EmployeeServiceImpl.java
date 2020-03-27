package Anno_Way.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Anno_Way.Dao.EmployeeDao;
import Anno_Way.Domain.Employee;
import Anno_Way.Service.EmployeeServiceDao;
@Service
public class EmployeeServiceImpl implements EmployeeServiceDao {
	@Autowired
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
