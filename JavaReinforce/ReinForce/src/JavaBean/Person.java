package JavaBean;

public class Person {
	String name;
	int age;
	int Id;

	// 属性名:name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 属性名：age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 属性名:id
	public void setId(int id) {
		Id = id;
	}

	public int getId() {
		return Id;
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", Id=" + Id + "]";
	}
}
