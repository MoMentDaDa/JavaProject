package com.wang.Mapper;

import org.apache.ibatis.annotations.Param;

import com.wang.Domain.Student;

public interface StudentMapper {
	void save(Student d);

	void insertRelation(@Param("studentId") Long studentID, @Param("teacherId") Long teacherID);

	Student get(Long id);

	void delete(Long id);

	void deleteRelationWithTeacher(Long id);
}
