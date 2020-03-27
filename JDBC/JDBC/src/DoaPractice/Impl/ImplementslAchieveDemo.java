package DoaPractice.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DoaPractice.daomain.Students;
import DoaPractice.util.SqlUntil;

public class ImplementslAchieveDemo implements StudentDaoInterface {

	@Override
	// INSERT INTO t_student (id,name,age,email) VALUES (6,'xx',17,'afa@qq.com')
	public void sava(Students stu) {
		// 申明资源对象
		Connection com = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "INSERT INTO t_student (id,name,age,email) VALUES (12,'wsffa',17,'sfa1@qq.com')";
		String sql1 = "INSERT INTO t_student (id,name,email,age) VALUES (";
		StringBuilder info = new StringBuilder(100);
		info.append(sql1);
		info.append(stu.getId());
		info.append(",'");
		info.append(stu.getName() + "','");
		info.append(stu.getEmail() + "',");
		info.append(stu.getAge());
		info.append(")");
		System.out.println(info);
		try {
			// 1、加载注册驱动，获取连接对象
			com = SqlUntil.getcon();
			// 3、创建语句对象
			st = com.createStatement();
			// 4、执行SQL语句
			st.executeUpdate(sql);
			st.executeUpdate(info.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、释放资源
			SqlUntil.close(com, st, null);
		}
	}

	@Override
	// DELETE FROM t_student WHERE id=5
	public void delete(int id) {
		// 申明资源对象
		Connection com = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "DELETE FROM t_student WHERE id=" + id;

		System.out.println(sql);
		try {
			// 1、加载注册驱动，获取连接对象
			com = SqlUntil.getcon();
			// 3、创建语句对象
			st = com.createStatement();
			// 4、执行SQL语句
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、释放资源
			SqlUntil.close(com, st, null);
		}

	}

	@Override
	// UPDATE t_students SET name='xx',age=12 WHERE id=12
	public void update(int id, Students newstu) {
		// 申明资源对象
		Connection com = null;
		Statement st = null;

		StringBuilder update = new StringBuilder(100);
		String sql = "UPDATE t_student SET name='";
		update.append(sql).append(newstu.getName() + "',");
		update.append("age=" + newstu.getAge() + " WHERE id=" + id);
		try {
			// 1、加载注册驱动，获取连接对象
			com = SqlUntil.getcon();
			// 3、创建语句对象
			st = com.createStatement();
			// 4、执行SQL语句
			st.executeUpdate(update.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、释放资源
			SqlUntil.close(com, st, null);
		}
	}

	@Override
	public Students get(int id) {
		String sql = "SELECT * FROM t_student WHERE id=" + id;
		// 申明资源对象
		Connection com = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1、加载注册驱动，获取连接对象
			com = SqlUntil.getcon();
			// 3、创建语句对象
			st = com.createStatement();
			// 4、执行SQL语句
			rs = st.executeQuery(sql);
			// 5、处理结果集
			if (rs.next()) {
				Students stu = new Students();
				// 获取当前光标所在行的ID列额的值,并设置到stu中
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setAge(rs.getInt("age"));
				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、释放资源
			SqlUntil.close(com, st, rs);
		}
		return null;
	}

	@Override
	public List<Students> listAll() {
		// 申明资源对象
		Connection com = null;
		Statement st = null;
		ResultSet rs = null;
		List<Students> list = new ArrayList<Students>();
		String sql = "SELECT * FROM `t_student`";
		try {
			// 1、加载注册驱动，获取连接对象
			com = SqlUntil.getcon();
			// 3、创建语句对象
			st = com.createStatement();
			// 4、执行SQL语句
			rs = st.executeQuery(sql);
			// 5、处理结果集
			while (rs.next()) {
				Students stu = new Students();
				// 获取当前光标所在行的ID列额的值,并设置到stu中
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、释放资源
			SqlUntil.close(com, st, rs);
		}
		return list;
	}

}
