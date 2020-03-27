package Day03.daomain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	private int id;
	private String name;
	private String email;
	private int age;

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}
