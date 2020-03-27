package Anno.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	// @Autowired 先按照类型去找，然后按照字段名去找，@Qualifier 可以指定名字

	@Autowired
	@Qualifier("cat1")
	private Cat c1;

	@Override
	public String toString() {
		return "Person [c1=" + c1 + "]";
	}
}
