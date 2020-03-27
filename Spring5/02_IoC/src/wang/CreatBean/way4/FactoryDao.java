package wang.CreatBean.way4;

import org.springframework.beans.factory.FactoryBean;

public class FactoryDao implements FactoryBean<cat4> {

	//实例工厂方法
	@Override
	public cat4 getObject() throws Exception {
		cat4 c4 = new cat4();
		return c4;
	}

	@Override
	public Class<?> getObjectType() {
		return cat4.class;//不能丢
	}

}
