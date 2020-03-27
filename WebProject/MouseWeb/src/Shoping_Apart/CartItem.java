package Shoping_Apart;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: CartItem
 * @Description: 购物车中的商品对象
 * @author: 汪哒哒
 * @date: 2019年6月11日 下午4:28:11
 */
@Data
@Setter
@Getter
public class CartItem {
	private String id;// 商品唯一id
	private String name;// 商品名称
	private BigDecimal price;// 商品单价
	private Integer num;// 购买数量

	public CartItem() {

	}

	public CartItem(String id, String name, BigDecimal price, Integer num) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + "]";
	}

}
