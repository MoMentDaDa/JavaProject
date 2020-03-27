package wang.SpringExample.Domain;

public class Employee {
	private String username;
	private int age;

	public void Employee() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void sayHello() {
		System.out.println("username:" + username + "，age:" + age);
	}
}
