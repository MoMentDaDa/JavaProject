package JDBC_Apart.Impl;

import java.util.List;

import JDBC_Apart.DaoMain.Student;

public interface StudentDaoInterface {
	/**
	 * 保存操作，封装学生对象信息
	 * 
	 * @param stu
	 */
	void sava(Student stu);

	/**
	 * 删除操作，
	 * 
	 * @param id
	 */
	void delete(long id);

	/**
	 * 更新操作，
	 * 
	 * @param id     被更改的学生ID
	 * @param newstu 学生新的信息
	 */
	void update(long id, Student newstu);

	/**
	 * 查询指定ID学生的信息
	 * 
	 * @param ID 被查学生的id
	 * @return Student 如果ID存在，则返回该学生的对象，否则为null
	 */
	Student get(long id);

	/**
	 * 查询并返回所有学生对象
	 * 
	 * @return 结果集为空，返回空的list对象
	 */
	List<Student> listAll();
}
