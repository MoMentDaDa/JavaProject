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

//����ʹ�÷�װ˼��ʵ�ָ߼���ѯ�ķ���
	@Override
	public List<Mouse> advancedSearch(ProductQueryObject go) {
		// String sql = "select * from mouse" + go.getQuerySQL();// ԭ�еĲ���ģ��
		String querySQL = go.getQuerySQL();// ʹ�û��ڻ�����չ�����ĺ���ģ��,��ȡ��벿�����
		String sql = "select * from mouse" + querySQL;
		//System.out.println("����=" + go.getParameters());
		//System.out.println("SQL���:" + sql);
		// System.out.println(sql.hashCode());
		return JdbcTemplate.Query(sql.toString(), new GeneralResultList<>(Mouse.class), go.getParameters().toArray());
		// return null;

	}

	/*
	 * ����ʹ�ö��������ʽ��ʵ�ַ��� public List<Mouse> advancedSearch(String name, String
	 * MaxPrice, String MinPrice) {
	 * 
	 * // String sql = "SELECT * FROM mouse WHERE 1=1"; StringBuilder sql = new
	 * StringBuilder(80); sql.append("SELECT * FROM mouse WHERE 1=1"); if
	 * (StringUtils.isNotBlank(name)) { // sql += " AND name LIKE '%" + name + "%'";
	 * sql.append(" AND name LIKE '%" + name + "%'"); } if
	 * (StringUtils.isNotBlank(MaxPrice)) { // sql += " AND �ο��۸�<=" + MaxPrice;
	 * sql.append(" AND �ο��۸�<=" + MaxPrice); } if (StringUtils.isNotBlank(MinPrice))
	 * { // sql += " AND �ο��۸�>=" + MinPrice; sql.append(" AND �ο��۸�<=" + MaxPrice); }
	 * // System.out.println("SQL:" + sql); try { com = pool.getConnection(); st =
	 * com.prepareStatement(sql.toString()); rs = st.executeQuery(); } catch
	 * (SQLException e) { e.printStackTrace(); } list = new ArrayList<Mouse>(); try
	 * { while (rs.next()) { Mouse m = new Mouse(); m.setId(rs.getInt("id"));
	 * m.setName(rs.getString("name")); m.setPrice(rs.getString("�ο��۸�"));
	 * m.setWeight(rs.getString("����")); m.setMaterial(rs.getString("����"));
	 * m.setEngineering(rs.getString("����")); list.add(m); } return list; } catch
	 * (SQLException e) { e.printStackTrace(); } finally { try { com.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } } return null;
	 * 
	 * //---------------------------------------------------------------------------
	 * -
	 * 
	 * StringBuilder sql=new StringBuilder(80);
	 * sql.append("SELECT * FROM mouse WHERE 1=1"); //��װռλ������ List<Object>
	 * parameters=new ArrayList<Object>(); //��Ʒ���� if(StringUtils.isNotBlank(name)) {
	 * sql.append(" AND name LIKE ?"); parameters.add("%"+name+"%"); }
	 * if(StringUtils.isNotBlank(MaxPrice)) { sql.append(" AND �ο��۸�<= ?");
	 * parameters.add(MaxPrice); } if(StringUtils.isNotBlank(MinPrice)) {
	 * sql.append(" AND �ο��۸�>= ?"); parameters.add(MinPrice); }
	 * //System.out.println(sql); //System.out.println(parameters); return
	 * JdbcTemplate.Query(sql.toString(), new
	 * GeneralResultList<>(Mouse.class),parameters.toArray()); }
	 */
}
