package JDBC_Apart.Object;

import JDBC_Apart.Dao.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
/**
 * @Title: getClassiFication
 * @Description: 鼠标封装对象
 * @return
 * @return: int
 */
@Getter
@Table("mouse")
public class Mouse {
	int id;
	String name;
	String price;
	String weight;
	String material;
	String engine;
	String wire;
	String footstick;
	int classiFication;

	public Mouse() {
	}

	@Override
	public String toString() {
		return "Mouse [id=" + id + ", name=" + name + ", price=" + price + ", weight=" + weight + ", material="
				+ material + ", engine=" + engine + ", wire=" + wire + ", footstick=" + footstick + ", classiFication="
				+ classiFication + "]";
	}



}
