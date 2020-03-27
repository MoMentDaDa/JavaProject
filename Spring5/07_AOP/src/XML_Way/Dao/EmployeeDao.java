package XML_Way.Dao;

import XML_Way.Domain.Employee;

public interface EmployeeDao {

	void save(Employee emp);

	void update(Employee emp);
}
