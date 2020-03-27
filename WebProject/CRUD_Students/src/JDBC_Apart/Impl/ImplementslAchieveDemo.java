package JDBC_Apart.Impl;

import java.util.List;

import JDBC_Apart.DaoMain.Student;
import JDBC_Apart.util.JdbcTemplate;

public class ImplementslAchieveDemo implements StudentDaoInterface {
	@Override
	// INSERT INTO t_student (id,name,age,email) VALUES (6,'xx',17,'afa@qq.com')
	public void sava(Student stu) {
		// 申明资源对象
		String sql = "INSERT INTO t_student(name,email,age) VALUES(?,?,?)";
		JdbcTemplate.Update(sql, stu.getName(), stu.getEmail(), stu.getAge());
	}

	@Override
	// UPDATE t_students SET name='xx',age=12 WHERE id=12
	public void update(long id, Student newstu) {
		String sql = "UPDATE t_student SET name=?,email=?,age=? WHERE id=?";
		JdbcTemplate.Update(sql,newstu.getName(), newstu.getEmail(), newstu.getAge(), id);
	}

	@Override
	// DELETE FROM t_student WHERE id=5
	public void delete(long id) {
		String sql = "DELETE FROM t_student WHERE id=?";
		JdbcTemplate.Update(sql, id);
	}

	@Override
	public Student get(long id) {
		String sql = "SELECT * FROM t_student WHERE id=?";
		return JdbcTemplate.Query(sql, new GeneralResult<>(Student.class), id);
	}

	@Override
	public List<Student> listAll() {
		return JdbcTemplate.Query("SELECT * FROM `t_student`", new GeneralResultList<>(Student.class));

	}

}
