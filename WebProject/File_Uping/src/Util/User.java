package Util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	String name;
	String email;
	String dirIMG;// ͷ���·��������UUID����
	String nameIMG;// ͷ���ԭʼ����

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dirIMG=" + dirIMG + ", nameIMG=" + nameIMG + "]";
	}
}
