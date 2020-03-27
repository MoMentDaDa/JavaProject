package JDBC_Apart.Dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Mouse {
	int id;
	String name;
	String price;
	String weight;
	String material;
	String engineering;

	@Override
	public String toString() {
		return "Mouse [id=" + id + ", name=" + name + ", price=" + price + ", weight=" + weight + ", Material="
				+ material + ", engineering=" + engineering + "]";
	}

	public Mouse() {
	}

}
