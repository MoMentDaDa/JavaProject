package Day05.DaoMain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//��װ����
public class Student {
	private long id;
	private String name;
	private String email;
	private int age;
	private String password;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", password=" + password
				+ "]";
	}
}
