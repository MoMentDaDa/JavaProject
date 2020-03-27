package ByAnno.service;

import java.util.List;

import ByAnno.domain.Employee;


public interface IEmployeeService {
	void save(Employee emp);

	void update(Employee emp);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> listAll();

	void login(String username, String password);

}
