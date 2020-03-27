package CGLIB_Proxy.tx;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import lombok.Setter;

//事务增强操作
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
		Enhancer enhhan = new Enhancer();
		enhhan.setSuperclass(target.getClass());// 将继承与哪一个类做增强
		enhhan.setCallback(this);
		return (T) enhhan.create();// 如何做事务增强的对象
	}

	// 如何为真实对象做具体增强操作
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-----------------------");
		System.out.println(method);
		System.out.println(Arrays.toString(args));
		System.out.println("-----------------------");

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
