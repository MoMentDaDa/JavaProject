package JDBC_Apart.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Dao.MouseInter;
import JDBC_Apart.Util.DataSource2;
import JDBC_Apart.Util.JdbcTemplate;
import JDBC_Apart.Util.MouseQueryObject;
import JDBC_Apart.adancedQuery.ProductQueryObject;

public class MouseImpl implements MouseInter {
	DataSource2 pool = new DataSource2();
	Connection com = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	List<Mouse> list = null;

	@Override
	public List<Mouse> list() {
		return JdbcTemplate.Query("SELECT * FROM `mouse`", new GeneralResultList<>(Mouse.class));
	}

	@Override
	public Mouse get(int id) {
		String sql = "select * from mouse where id=?";
		return JdbcTemplate.Query(sql, new GeneralResult<>(Mouse.class), id);
	}

	@Override
	public void save(Mouse newMou) {
		String sql = "insert into mouse (name,price,weight,material,engine,wire,footstick,classiFication) values (?,?,?,?,?,?,?,?)";
		JdbcTemplate.Update(sql, newMou.getName(), newMou.getPrice(), newMou.getWeight(), newMou.getMaterial(),
				newMou.getEngine(), newMou.getWire(), newMou.getFootstick(), newMou.getClassiFication());

	}

	@Override
	public void update(Mouse newMou, int id) {
		String sql = "update mouse set name=?,price=?,weight=?,material=?,engine=?,wire=?,footstick=?,classiFication=?  where id=?";
		JdbcTemplate.Update(sql, newMou.getName(), newMou.getPrice(), newMou.getWeight(), newMou.getMaterial(),
				newMou.getEngine(), newMou.getWire(), newMou.getFootstick(), newMou.getClassiFication(), id);

	}

	@Override
	public void delete(int id) {
		String sql = "delete from mouse where id=?";
		JdbcTemplate.Update(sql, id);
	}

//这是使用封装思想实现高级查询的方法
	@Override
	public List<Mouse> advancedSearch(ProductQueryObject go) {
		// String sql = "select * from mouse" + go.getQuerySQL();// 原有的参数模版
		String querySQL = go.getQuerySQL();// 使用基于基类扩展而来的函数模板,获取后半部分语句
		String sql = "select * from mouse" + querySQL;
		//System.out.println("参数=" + go.getParameters());
		//System.out.println("SQL语句:" + sql);
		// System.out.println(sql.hashCode());
		return JdbcTemplate.Query(sql.toString(), new GeneralResultList<>(Mouse.class), go.getParameters().toArray());
		// return null;

	}

	/*
	 * 这是使用多个参数方式的实现方法 public List<Mouse> advancedSearch(String name, String
	 * MaxPrice, String MinPrice) {
	 * 
	 * // String sql = "SELECT * FROM mouse WHERE 1=1"; StringBuilder sql = new
	 * StringBuilder(80); sql.append("SELECT * FROM mouse WHERE 1=1"); if
	 * (StringUtils.isNotBlank(name)) { // sql += " AND name LIKE '%" + name + "%'";
	 * sql.append(" AND name LIKE '%" + name + "%'"); } if
	 * (StringUtils.isNotBlank(MaxPrice)) { // sql += " AND 参考价格<=" + MaxPrice;
	 * sql.append(" AND 参考价格<=" + MaxPrice); } if (StringUtils.isNotBlank(MinPrice))
	 * { // sql += " AND 参考价格>=" + MinPrice; sql.append(" AND 参考价格<=" + MaxPrice); }
	 * // System.out.println("SQL:" + sql); try { com = pool.getConnection(); st =
	 * com.prepareStatement(sql.toString()); rs = st.executeQuery(); } catch
	 * (SQLException e) { e.printStackTrace(); } list = new ArrayList<Mouse>(); try
	 * { while (rs.next()) { Mouse m = new Mouse(); m.setId(rs.getInt("id"));
	 * m.setName(rs.getString("name")); m.setPrice(rs.getString("参考价格"));
	 * m.setWeight(rs.getString("重量")); m.setMaterial(rs.getString("材质"));
	 * m.setEngineering(rs.getString("引擎")); list.add(m); } return list; } catch
	 * (SQLException e) { e.printStackTrace(); } finally { try { com.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } } return null;
	 * 
	 * //---------------------------------------------------------------------------
	 * -
	 * 
	 * StringBuilder sql=new StringBuilder(80);
	 * sql.append("SELECT * FROM mouse WHERE 1=1"); //封装占位符参数 List<Object>
	 * parameters=new ArrayList<Object>(); //商品名称 if(StringUtils.isNotBlank(name)) {
	 * sql.append(" AND name LIKE ?"); parameters.add("%"+name+"%"); }
	 * if(StringUtils.isNotBlank(MaxPrice)) { sql.append(" AND 参考价格<= ?");
	 * parameters.add(MaxPrice); } if(StringUtils.isNotBlank(MinPrice)) {
	 * sql.append(" AND 参考价格>= ?"); parameters.add(MinPrice); }
	 * //System.out.println(sql); //System.out.println(parameters); return
	 * JdbcTemplate.Query(sql.toString(), new
	 * GeneralResultList<>(Mouse.class),parameters.toArray()); }
	 */
}
