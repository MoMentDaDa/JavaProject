package JDBC_Apart.Dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	String username;
	String password;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
