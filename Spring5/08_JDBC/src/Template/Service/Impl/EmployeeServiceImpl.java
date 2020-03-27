package Template.Service.Impl;

import Template.Dao.EmployeeDao;
import Template.Domain.Employee;
import Template.Service.EmployeeServiceDao;
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
