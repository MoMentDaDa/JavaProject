package Template.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Template.Domain.Employee;
import lombok.SneakyThrows;

public class EmployeeImpl implements Template.Dao.EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	// 间接获取数据库连接
	public void setDataSources(DataSource dataSources) {
		this.jdbcTemplate = new JdbcTemplate(dataSources);
	}

	@SneakyThrows
	public void save(Employee emp) {
		System.out.println("保存操作。。");
		jdbcTemplate.update("insert into employee(name,age) values (?,?)", emp.getName(), emp.getAge());
		System.out.println("保存成功");
	}

	@Override
	public void update(Employee emp, Long id) {
		System.out.println("更新操作。。");
		jdbcTemplate.update("update employee set name=?,age=? where id=?", emp.getName(), emp.getAge(), id);
	}

	@Override
	public void delete(Long id) {
		System.out.println("删除操作。。");
		jdbcTemplate.update("delete from employee where id=?", id);

	}

	@Override
	public Employee get(Long id) {
		System.out.println("查询单个操作。。");
		// 使用 lomba 表达式，效果和内部类一样
		List<Employee> list = jdbcTemplate.query("SELECT id,name,age FROM employee WHERE id = ?", (rs, rowNum) -> {
			Employee e = new Employee();
			e.setId(rs.getLong("id"));
			e.setName(rs.getString("name"));
			e.setAge(rs.getInt("age"));
			return e;
		}, id);
		return list.size() == 1 ? list.get(0) : null;

	}

	@Override
	public List<Employee> listAll() {
		System.out.println("查询所有操作。。");
		return jdbcTemplate.query("SELECT id,name,age FROM employee", new Object[] {}, new RowMapper<Employee>() {
			// 使用内部类，把结果集映射成对象
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getLong("id"));
				e.setName(rs.getString("name"));
				e.setAge(rs.getInt("age"));
				return e;
			}

		});
	}

}
