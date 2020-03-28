package ByXML.dao;

import java.util.List;

import ByXML.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee emp);

	void update(Employee emp);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> listAll();

	Employee checkLogin(String username, String password);
}