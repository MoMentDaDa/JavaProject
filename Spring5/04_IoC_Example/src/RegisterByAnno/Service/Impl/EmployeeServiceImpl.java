package RegisterByAnno.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Register.Dao.EmployeeDao;
import Register.Domain.Employee;
import Register.Service.EmployeeServiceDao;
@Service
public class EmployeeServiceImpl implements EmployeeServiceDao {
	@Autowired
	private EmployeeDao dao;

	@Override
	public void register(Employee e) {
		System.out.println("注册操作");
		dao.save(e);
	}

}
