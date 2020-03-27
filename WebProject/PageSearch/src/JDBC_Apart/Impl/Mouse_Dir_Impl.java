package JDBC_Apart.Impl;

import java.util.List;

import JDBC_Apart.Dao.I_MouseDir;
import JDBC_Apart.Dao.MouseDir;
import JDBC_Apart.Util.JdbcTemplate;

public class Mouse_Dir_Impl implements I_MouseDir {

	@Override
	public List<MouseDir> list() {
		return JdbcTemplate.Query("SELECT * FROM `mousedir`", new GeneralResultList<>(MouseDir.class));
	}

	@Override
	public MouseDir get(int id) {
		String sql = "select * from mousedir where id=?";
		return JdbcTemplate.Query(sql, new GeneralResult<>(MouseDir.class), id);
	}

	@Override
	public void save(MouseDir newDir) {
		String sql = "INSERT INTO mousedir (id,dirName) VALUES (?,?)";
		JdbcTemplate.Update(sql, newDir.getId(),newDir.getDirName());
	}

	@Override
	public void update(MouseDir newDir, int id) {
		String sql = "UPDATE mousedir SET className=?,parent_id=? WHERE id=?";
		JdbcTemplate.Update(sql, newDir.getDirName(), newDir.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM mousedir WHERE id=?";
		JdbcTemplate.Update(sql, id);
	}
}
