package DoaPractice.daomain;

import lombok.Getter;
import lombok.Setter;

//·â×°¶ÔÏó
@Setter
@Getter
public class Students {
	private int id;
	private String name;
	private String email;
	private int age;
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}
