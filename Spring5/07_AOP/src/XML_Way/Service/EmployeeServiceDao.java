package XML_Way.Service;

import XML_Way.Domain.Employee;

//定义一个注册的Dao
public interface EmployeeServiceDao {

	void save(Employee emp);

	void update(Employee emp);
}