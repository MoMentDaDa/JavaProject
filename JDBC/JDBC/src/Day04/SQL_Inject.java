package Day04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import DoaPractice.util.SqlUntil;

public class SQL_Inject {
	private Connection com = SqlUntil.getcon();
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;

	@Test
	public void testByStatement() {
		String sql = "SELECT * FROM t_student WHERE name='ÇÇ·å' AND password='admin424'";
		String sql1 = "SELECT * FROM t_student WHERE name=' ' OR 1=1 OR ' ' AND password='11'";
		try {
			st = com.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println("µÇÂ½³É¹¦" + rs.toString());
			} else {
				System.out.println("µÇÂ¼Ê§°Ü");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}
	}

	@Test
	public void testByPreparedStatement() {
		String sql = "SELECT * FROM t_student WHERE name=? AND password=?";
		try {
			ps = com.prepareStatement(sql);
			ps.setString(1, "' OR 1=1 OR'");
			ps.setString(2, "22");
			rs=ps.executeQuery();
			if (rs.next()) {
				System.out.println("µÇÂ½³É¹¦" + rs.toString());
			} else {
				System.out.println("µÇÂ¼Ê§°Ü");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUntil.close(com, ps, rs);
		}

	}

}
