package Util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	String name;
	String email;
	String dirIMG;// 头像的路径，包含UUID名称
	String nameIMG;// 头像的原始名称

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dirIMG=" + dirIMG + ", nameIMG=" + nameIMG + "]";
	}
}
