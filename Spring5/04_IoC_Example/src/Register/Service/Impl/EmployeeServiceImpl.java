package Register.Service.Impl;

import Register.Dao.EmployeeDao;
import Register.Domain.Employee;
import Register.Service.EmployeeServiceDao;
import lombok.Setter;

public class EmployeeServiceImpl implements EmployeeServiceDao {
	@Setter
	private EmployeeDao dao;

	@Override
	public void register(Employee e) {
		System.out.println("注册操作");
		dao.save(e);
	}

}
