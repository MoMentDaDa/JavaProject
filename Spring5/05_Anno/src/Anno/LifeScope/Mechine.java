package Anno.LifeScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("PROTOTYPE")//注解属性值可以写成枚举类型，也可以直接使用值
public class Mechine {

	@PostConstruct // 贴在初始化的方法上
	public void open() {
		System.out.println("初始化方法");
	}

	@PreDestroy // 贴在销毁方法上
	public void close() {
		System.out.println("销毁方法");
	}

	public void doWork() {
		System.out.println("工作");
	}

	public Mechine() {
		System.out.println("创建 Mechine 对象");
	}

}
