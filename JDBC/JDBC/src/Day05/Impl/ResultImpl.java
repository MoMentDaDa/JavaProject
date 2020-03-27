package Day05.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Day05.DaoMain.Student;

/**
 * 该实现类只能处理特定的类型，不能实现通用结果集处理，存在缺陷
 * 
 * @author 汪哒哒
 *
 */
public class ResultImpl implements ResultUtil<List<Student>> {

	public List<Student> handle(ResultSet rs) throws Exception {
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student stu = new Student();
			// 获取当前光标所在行的ID列额的值,并设置到stu中
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setEmail(rs.getString("email"));
			stu.setAge(rs.getInt("age"));
			list.add(stu);
		}
		return list;
	}

}
