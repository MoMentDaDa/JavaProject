package XML_Way.tx;

//模拟事务管理器:
public class TransactionManager {
	public void begin() {
		System.out.println("开启事务");
	}

	public void commit() {
		System.out.println("提交事务");
	}

	public void rollback() {
		System.out.println("回滚事务");
	}

	public void close() {
		System.out.println("释放资源");
	}

	public Object around() {
		Object ret = null;
		System.out.println("开启事务");
		try {
			// 执行目标方法
			System.out.println("执行目标方法");
			System.out.println("提交事务");
		} catch (Throwable ex) {
			System.out.println("回滚事务");
		} finally {
			System.out.println("释放资源");
		}
		return ret;

	}
}
