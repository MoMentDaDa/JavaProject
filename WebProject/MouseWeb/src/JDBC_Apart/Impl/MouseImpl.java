package JDBC_Apart.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.MouseInter;
import JDBC_Apart.Util.DataSource2;

public class MouseImpl implements MouseInter {
	DataSource2 pool = new DataSource2();
	Connection com = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	List<Mouse> list = null;

	@Override
	public List<Mouse> list() {
		try {
			com = pool.getConnection();
			// System.out.println(com);
			String sql = "select * from mouse";
			st = com.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<Mouse>();

			while (rs.next()) {
				Mouse m = new Mouse();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPrice(rs.getString("参考价格"));
				m.setWeight(rs.getString("重量"));
				m.setMaterial(rs.getString("材质"));
				m.setEngineering(rs.getString("引擎"));
				list.add(m);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public Mouse get(int id) {
		try {
			com = pool.getConnection();
			String sql = "select * from mouse where id=?";
			st = com.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				Mouse m = new Mouse();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPrice(rs.getString("参考价格"));
				m.setWeight(rs.getString("重量"));
				m.setMaterial(rs.getString("材质"));
				m.setEngineering(rs.getString("引擎"));
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void save(Mouse newMou) {
		try {
			com = pool.getConnection();
			String sql = "insert into mouse (name,参考价格,重量,材质,引擎) values (?,?,?,?,?)";
			st = com.prepareStatement(sql);
			st.setString(1, newMou.getName());
			st.setString(2, newMou.getPrice());
			st.setString(3, newMou.getWeight());
			st.setString(4, newMou.getMaterial());
			st.setString(5, newMou.getEngineering());
			// System.out.println(st.toString());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Mouse newMou, int id) {
		try {
			com = pool.getConnection();
			String sql = "update mouse set name=?,参考价格=?,重量=?,材质=?,引擎=?  where id=?";
			st = com.prepareStatement(sql);
			st.setString(1, newMou.getName());
			st.setString(2, newMou.getPrice());
			st.setString(3, newMou.getWeight());
			st.setString(4, newMou.getMaterial());
			st.setString(5, newMou.getEngineering());
			st.setInt(6, id);
			// System.out.println(st.toString());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int id) {
		try {
			com = pool.getConnection();
			String sql = "delete from mouse where id=?";
			st = com.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				com.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
