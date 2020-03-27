package Shoping_Apart;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: CartItem
 * @Description: ���ﳵ�е���Ʒ����
 * @author: ������
 * @date: 2019��6��11�� ����4:28:11
 */
@Data
@Setter
@Getter
public class CartItem {
	private String id;// ��ƷΨһid
	private String name;// ��Ʒ����
	private BigDecimal price;// ��Ʒ����
	private Integer num;// ��������

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
