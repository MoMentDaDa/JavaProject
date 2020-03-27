package Day05.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Day05.DaoMain.Student;

/**
 * ��ʵ����ֻ�ܴ����ض������ͣ�����ʵ��ͨ�ý������������ȱ��
 * 
 * @author ������
 *
 */
public class ResultImpl implements ResultUtil<List<Student>> {

	public List<Student> handle(ResultSet rs) throws Exception {
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student stu = new Student();
			// ��ȡ��ǰ��������е�ID�ж��ֵ,�����õ�stu��
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setEmail(rs.getString("email"));
			stu.setAge(rs.getInt("age"));
			list.add(stu);
		}
		return list;
	}

}
