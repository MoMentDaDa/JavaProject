package Generic_JavaBook;

import java.util.*;

public class LimitBag<T extends Number> {
//利用extends限制类型参数，即上下限
	private T content;

	public LimitBag(T content) {
		this.content = content;
	}

	private void set() {
		this.content = content;

	}

	private T get(T content) {
		return this.content;

	}

	public static void main(String[] args) {	
		LimitBag<Integer> bag2 = new LimitBag<Integer>(12);//合法，因为继承的是Number，所以T可以为指定类和其子类。若为接口名，则为指定接口的实现类
		//不合法，因为List不是Number的子类
		//Limit<List> bag1 = new LimitBag<List>(new ArrayList());

	}

}
