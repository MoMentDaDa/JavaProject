package JDBC_Apart.Object;

import lombok.Getter;
import lombok.Setter;

@Getter
/**
 * @Title: setPassword
 * @Description:用户名和密码封装对象
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
