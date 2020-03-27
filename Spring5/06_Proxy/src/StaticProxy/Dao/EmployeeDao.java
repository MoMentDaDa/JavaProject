package StaticProxy.Dao;

import StaticProxy.Domain.Employee;

public interface EmployeeDao {

	void save(Employee emp);

	void update(Employee emp);
}
