package Day04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import DoaPractice.util.SqlUntil;

public class Transation {
	private Connection com = SqlUntil.getcon();
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;

//未使用事物测试
	@Test
	public void noTransation() {
		try {
			// ------------查询余额是否充足
			String sql = "SELECT * FROM transation WHERE name=? AND salary >=?";
			ps = com.prepareStatement(sql);
			ps.setString(1, "张无忌");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("余额不足");
			}
			// -------------减少张无忌工资1000
			sql = "UPDATE transation SET salary=salary-? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "张无忌");
			ps.executeUpdate();
			// 模拟中途断电操作
			int a = 9 / 0;
			// ------------增加赵敏1000
			sql = "UPDATE transation SET salary=salary+? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "赵敏");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}
	}

//使用事物操作
	@Test
	public void testByTransation() {
		try {
			com.setAutoCommit(false);// 设置事物手动提交
			// ------------查询余额是否充足
			String sql = "SELECT * FROM transation WHERE name=? AND salary >=?";
			ps = com.prepareStatement(sql);
			ps.setString(1, "张无忌");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("余额不足");
			}
			// -------------减少张无忌工资1000
			sql = "UPDATE transation SET salary=salary-? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "张无忌");
			ps.executeUpdate();
			// ------------增加赵敏1000
			// 模拟中途断电操作
			int a = 9 / 0;
			sql = "UPDATE transation SET salary=salary+? WHERE name=?";
			ps = com.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "赵敏");
			ps.executeUpdate();
			com.commit();// 提交事物，并释放资源锁
		} catch (SQLException e) {
			e.printStackTrace();
			// 一旦事物出现异常，实现回滚操作，保证数据的原子性
			try {
				com.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			SqlUntil.close(com, ps, rs);

		}

	}

}
