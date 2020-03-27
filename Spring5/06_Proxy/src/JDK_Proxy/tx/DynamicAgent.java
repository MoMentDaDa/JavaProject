package JDK_Proxy.tx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import lombok.Setter;
@SuppressWarnings("all")
public class DynamicAgent implements InvocationHandler {
	private Object target;// 真实对象类型
	private TransactionManager txManger;// 事务管理器

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setTxManger(TransactionManager txManger) {
		this.txManger = txManger;
	}

	// 创建代理对象
	public <T> T getProxyObject() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), // 类加载器，一般跟上真实对象的累加器
				target.getClass().getInterfaces(), // 真实对象所实现的接口（JDK动态代理必须要求真实对象有接口）
				this);// 如何做事务增强的对象
	}

	// 如何为真实对象做具体增强操作
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//System.out.println(proxy.getClass());
		//System.out.println(method);
		//System.out.println(Arrays.toString(args));

		Object ret = null;
		txManger.begin();
		try {
			// -------------
			ret = method.invoke(target, args);// 调用真实实现类的方法
			txManger.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txManger.rollback();
		}

		return ret;
	}

}
