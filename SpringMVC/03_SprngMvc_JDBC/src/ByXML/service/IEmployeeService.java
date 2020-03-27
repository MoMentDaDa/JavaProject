package ByXML.service;

import java.util.List;

import ByXML.domain.Employee;


public interface IEmployeeService {
	void save(Employee emp);

	void update(Employee emp);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> listAll();

	Employee login(String username, String password);
}
