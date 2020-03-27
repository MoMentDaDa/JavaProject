package JDK_Proxy.Service;

import JDK_Proxy.Domain.Employee;

//定义一个注册的Dao
public interface EmployeeServiceDao {

	void save(Employee emp);

	void update(Employee emp);
}