package com.wang.Test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wang.Domain.Student;
import com.wang.Domain.Teacher;
import com.wang.Mapper.StudentMapper;
import com.wang.Mapper.TeacherMapper;
import com.wang.Utils.MyBatisUtil;

public class TestDemo {
	@Test
	public void testSave() {
		Teacher t1 = new Teacher();
		t1.setName("老师1");

		Teacher t2 = new Teacher();
		t2.setName("老师2");

		Student s1 = new Student();
		s1.setName("小明");
		Student s2 = new Student();
		s2.setName("小王");

		// 维护关系
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);

		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);

		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		teacherMapper.save(t1);
		teacherMapper.save(t2);
		studentMapper.save(s1);
		studentMapper.save(s2);
		// s1学生来维护和老师的关系
		for (Teacher t : s1.getTeachers()) {
			studentMapper.insertRelation(s1.getId(), t.getId());
		}
		// s2学生来维护和老师的关系
		for (Teacher t : s2.getTeachers()) {
			studentMapper.insertRelation(s2.getId(), t.getId());

		}
		session.commit();
	}

	@Test
	public void testGet() {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student s = studentMapper.get(1L);
		System.out.println(s.toString());
		System.out.println(s.getTeachers().toString());

	}

	@Test
	public void testDelete() {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.deleteRelationWithTeacher(1L);
		studentMapper.delete(1L);
		session.commit();

	}

}
