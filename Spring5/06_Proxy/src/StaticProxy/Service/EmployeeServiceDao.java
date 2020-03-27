package StaticProxy.Service;

import StaticProxy.Domain.Employee;

//定义一个注册的Dao
public interface EmployeeServiceDao {

	void save(Employee emp);

	void update(Employee emp);
}