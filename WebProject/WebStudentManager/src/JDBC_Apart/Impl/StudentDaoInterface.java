package JDBC_Apart.Impl;

import java.util.List;

import JDBC_Apart.daomain.Students;


public interface StudentDaoInterface {
	/**
	 * �����������װѧ��������Ϣ
	 * 
	 * @param stu
	 */
	void sava(Students stu);

	/**
	 * ɾ��������
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * ���²�����
	 * 
	 * @param id     �����ĵ�ѧ��ID
	 * @param newstu ѧ���µ���Ϣ
	 */
	void update(int id, Students newstu);

	/**
	 * ��ѯָ��IDѧ������Ϣ
	 * 
	 * @param ID ����ѧ����id
	 * @return Student ���ID���ڣ��򷵻ظ�ѧ���Ķ��󣬷���Ϊnull
	 */
	Students get(int id);

	/**
	 * ��ѯ����������ѧ������
	 * 
	 * @return �����Ϊ�գ����ؿյ�list����
	 */
	List<Students> listAll();
}
