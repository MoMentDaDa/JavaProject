package StaticProxy.Proxy;

import StaticProxy.Domain.Employee;
import StaticProxy.Service.EmployeeServiceDao;
import StaticProxy.tx.TransactionManager;

//静态代理类
public class EmployeeServiceProxy implements EmployeeServiceDao {
	private EmployeeServiceDao target;// 真实对象/委托对象

	private TransactionManager txManager;// 事务管理器

	public void setTarget(EmployeeServiceDao target) {
		this.target = target;
	}

	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}

	public void save(Employee emp) {
		txManager.begin();
		try {
			target.save(emp);
			txManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
	}

	public void update(Employee emp) {
		txManager.begin();
		try {
			target.update(emp);
			txManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
	}
}
