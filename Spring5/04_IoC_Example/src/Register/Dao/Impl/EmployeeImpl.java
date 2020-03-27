package Register.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import Register.Domain.Employee;
import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;

public class EmployeeImpl implements Register.Dao.EmployeeDao {

	@Setter
	private DataSource dataSource;

	@SneakyThrows
	public void save(Employee e) {
		System.out.println("保存操作。。");
		@Cleanup
		Connection conn = dataSource.getConnection();
		String sql = "insert into employee(name,age) values(?,?)";
		@Cleanup
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.executeUpdate();

	}

}
