package LogUtil.Dao;

import LogUtil.Domain.Employee;

public interface EmployeeDao {

	void save(Employee emp);

	void update(Employee emp);
}
