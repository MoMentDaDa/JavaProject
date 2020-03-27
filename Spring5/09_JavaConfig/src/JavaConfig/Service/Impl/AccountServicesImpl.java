package JavaConfig.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import JavaConfig.Dao.AccountDao;
import JavaConfig.Service.AccountServiceDao;

@Service
@Transactional // 可以设置事务的属性
public class AccountServicesImpl implements AccountServiceDao {
	@Autowired
	private AccountDao dao;

	public void trans(Long outId, Long inId, int money) {
		dao.transOut(outId, money);
		int a = 1 / 0;// 模拟程序有异常
		dao.transIn(inId, money);
	}

	// 特殊的设置特殊的事务方法
	@Transactional(readOnly = true)
	public void listXxx() {
	}
}
