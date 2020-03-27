package Day3;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	String name;
	String password;

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

}
