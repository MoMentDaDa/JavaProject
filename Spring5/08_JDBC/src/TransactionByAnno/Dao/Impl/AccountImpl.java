package TransactionByAnno.Dao.Impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import TransactionByAnno.Dao.AccountDao;


@Repository
public class AccountImpl implements AccountDao {
	private JdbcTemplate jdbcTemplate;

	// 间接获取数据库连接,
	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public void transOut(Long outId, int money) {
		jdbcTemplate.update("UPDATE account SET balance = balance - ? WHERE id = ?", money, outId);
	}

	public void transIn(Long inId, int money) {
		jdbcTemplate.update("UPDATE account SET balance = balance + ? WHERE id = ?", money, inId);
	}

}
