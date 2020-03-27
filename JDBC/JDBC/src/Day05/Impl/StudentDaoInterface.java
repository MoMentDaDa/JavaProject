package Day05.Impl;

import java.util.List;
import Day05.DaoMain.Student;

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
	void delete(int id);

	/**
	 * ���²�����
	 * 
	 * @param id     �����ĵ�ѧ��ID
	 * @param newstu ѧ���µ���Ϣ
	 */
	void update(int id, Student newstu);

	/**
	 * ��ѯָ��IDѧ������Ϣ
	 * 
	 * @param ID ����ѧ����id
	 * @return Student ���ID���ڣ��򷵻ظ�ѧ���Ķ��󣬷���Ϊnull
	 */
	Student get(int id);

	/**
	 * ��ѯ����������ѧ������
	 * 
	 * @return �����Ϊ�գ����ؿյ�list����
	 */
	List<Student> listAll();
}
