package Anno_Way.Dao.Impl;

import org.springframework.stereotype.Repository;

import Anno_Way.Domain.Employee;
@Repository
public class EmployeeImpl implements Anno_Way.Dao.EmployeeDao {
	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
