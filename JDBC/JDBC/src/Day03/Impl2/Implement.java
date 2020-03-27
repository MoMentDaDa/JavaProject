package Day03.Impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Day03.daomain.Student;
import DoaPractice.daomain.Students;
import DoaPractice.util.SqlUntil;

public class Implement implements StudentMethod {
	Connection com = SqlUntil.getcon();
	PreparedStatement ps = null;
	List<Student> list = null;
	ResultSet rs = null;

	@Override
	public void sava(Students stu) {
		String sql = "INSERT INTO t_student (id,name,email,age) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = com.prepareStatement(sql);
			ps.setInt(1, stu.getId());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getEmail());
			ps.setInt(4, stu.getAge());
			ps.executeUpdate();
			SqlUntil.close(com, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE  FROM t_student WHERE id=?";
		try {
			ps = com.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, null);
		}
	}

	@Override
	public void update(int id, Students newstu) {
		String sql = "UPDATE t_student SET name=?,age=? WHERE id=?";
		try {
			PreparedStatement ps = com.prepareStatement(sql);
			ps.setString(1, newstu.getName());
			ps.setInt(2, newstu.getAge());
			ps.setInt(3, id);
			ps.executeUpdate();
			SqlUntil.close(com, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Students get(int id) {
		String sql = "SELECT * FROM t_student WHERE id=?";
		try {
			ps = com.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Students stu = new Students();
				// 获取当前光标所在行的ID列额的值,并设置到stu中
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setAge(rs.getInt("age"));
				return stu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, null);
		}
		return null;
	}

	@Override
	public List<Student> ListAll() {
		list = new ArrayList<Student>();
		String sql = "SELECT * FROM t_student";
		try {
			ps = com.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				Student stu = new Student();
				// 获取当前光标所在行的ID列额的值,并设置到stu中
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}
		return list;
	}
}
