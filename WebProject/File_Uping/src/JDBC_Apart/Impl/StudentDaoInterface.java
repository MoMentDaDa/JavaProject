package JDBC_Apart.Impl;

import java.util.List;

import JDBC_Apart.DaoMain.Student;

public interface StudentDaoInterface {
	/**
	 * �����������װѧ��������Ϣ
	 * 
	 * @param stu
	 */
	void sava(Student stu);

	/**
	 * ɾ��������
	 * 
	 * @param id
	 */
	void delete(long id);

	/**
	 * ���²�����
	 * 
	 * @param id     �����ĵ�ѧ��ID
	 * @param newstu ѧ���µ���Ϣ
	 */
	void update(long id, Student newstu);

	/**
	 * ��ѯָ��IDѧ������Ϣ
	 * 
	 * @param ID ����ѧ����id
	 * @return Student ���ID���ڣ��򷵻ظ�ѧ���Ķ��󣬷���Ϊnull
	 */
	Student get(long id);

	/**
	 * ��ѯ����������ѧ������
	 * 
	 * @return �����Ϊ�գ����ؿյ�list����
	 */
	List<Student> listAll();
}
