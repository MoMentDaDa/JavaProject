package Template.Dao;

import java.util.List;

import Template.Domain.Employee;

public interface EmployeeDao {
	void save(Employee emp);

	void update(Employee emp,Long id);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> listAll();
}
