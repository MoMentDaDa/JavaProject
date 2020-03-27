package Anno.Resource;

import javax.annotation.Resource;

public class Person {
	// @Resource 先按照名字找，再按类型找，可以通过 name 指定

	@Resource(name = "cat1")
	private Cat c1;

	@Override
	public String toString() {
		return "Person [c1=" + c1 + "]";
	}
}
