package SetterDi_02.Object;

//需求：演示 setter 注入对象类型
public class Person1 {
	private Cat1 c1;

	public Cat1 getC1() {
		return c1;
	}

	public void setC1(Cat1 c1) {
		this.c1 = c1;
	}

	@Override
	public String toString() {
		return "Person1 [c1=" + c1 + "]";
	}

}
