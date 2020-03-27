package TransactionByXML.Service.Impl;

import TransactionByXML.Dao.AccountDao;
import TransactionByXML.Service.AccountServiceDao;

public class AccountServicesImpl implements AccountServiceDao {
	private AccountDao dao;

	public void setDao(AccountDao dao) {
		this.dao = dao;
	}


	public void trans(Long outId, Long inId, int money) {
		dao.transOut(outId, money);
		int a = 1 / 0;//模拟程序有异常
		dao.transIn(inId, money);
	}
}
