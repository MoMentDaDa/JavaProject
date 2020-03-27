package Session;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfo implements Serializable{
	private Long id;
	String name;
	String passwrod;

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", passwrod=" + passwrod + "]";
	}

}
