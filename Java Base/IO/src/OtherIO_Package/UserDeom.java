package OtherIO_Package;

//序列化的对象类
public class UserDeom implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	String passward;

	public String toString() {
		return "UserDeom [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserDeom(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
