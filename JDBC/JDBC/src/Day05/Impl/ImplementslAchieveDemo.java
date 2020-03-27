package Day05.Impl;

import java.util.List;

import Day05.DaoMain.Student;
import Day05.util.JdbcTemplate;

public class ImplementslAchieveDemo implements StudentDaoInterface {
	@Override
	// INSERT INTO t_student (id,name,age,email) VALUES (6,'xx',17,'afa@qq.com')
	public void sava(Student stu) {
		// 申明资源对象
		String sql = "INSERT INTO t_student(id,name) VALUES(?,?)";
		JdbcTemplate.Update(sql, stu.getId(), stu.getName());
	}

	@Override
	// UPDATE t_students SET name='xx',age=12 WHERE id=12
	public void update(int id, Student newstu) {
		String sql = "UPDATE t_student SET email=?,age=? WHERE id=?";
		JdbcTemplate.Update(sql, newstu.getEmail(), newstu.getAge(), id);
	}

	@Override
	// DELETE FROM t_student WHERE id=5
	public void delete(int id) {
		String sql = "DELETE FROM t_student WHERE id=?";
		JdbcTemplate.Update(sql, id);
	}

	@Override
	public Student get(int id) {
		String sql = "SELECT * FROM t_student WHERE id=?";
		return JdbcTemplate.Query(sql, new GeneralResult<>(Student.class), id);
	}

	@Override
	public List<Student> listAll() {
		return JdbcTemplate.Query("SELECT * FROM `t_student`", new GeneralResultList<>(Student.class));

	}

}
