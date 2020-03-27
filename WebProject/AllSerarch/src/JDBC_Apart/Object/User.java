package JDBC_Apart.Object;

import lombok.Getter;
import lombok.Setter;

@Getter
/**
 * @Title: setPassword
 * @Description:�û����������װ����
 * @param password
 * @return: void
 */
@Setter
public class User {
	String username;
	String password;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
