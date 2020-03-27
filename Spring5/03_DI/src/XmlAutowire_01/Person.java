package XmlAutowire_01;

//需求：让 Spring 创建依赖 Dog 的 person 对象
public class Person {
	private Dog dog;

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Person [dog=" + dog + "]";
	}

}
