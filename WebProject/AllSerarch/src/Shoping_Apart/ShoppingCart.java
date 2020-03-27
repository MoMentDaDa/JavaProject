package Shoping_Apart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: ShoppingCart
 * @Description:���ﳵ�Զ���
 * @author: ������
 * @date: 2019��6��11�� ����4:29:02
 */
public class ShoppingCart {
	private List<CartItem> items = new ArrayList<CartItem>();// ���ﳵ�еĶ����Ʒ����

	// ����Ʒ��ӵ����ﳵ
	public void saveItem(CartItem newItem) {
		for (CartItem item : items) { // �ж��Ƿ����и���Ʒ
			if (item.getId().equals(newItem.getId())) {
				item.setNum(item.getNum() + newItem.getNum());
				return;
			}
		}
		items.add(newItem);
	}

	// �ӹ��ﳵ���Ƴ�ָ������Ʒ
	public void delete(String id) {
		Iterator<CartItem> it = items.iterator();
		while (it.hasNext()) {
			CartItem item = it.next();
			if (item.getId().equals(id)) {
				it.remove();
			}
			break;
		}
	}

	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (CartItem item : items) {
			totalPrice = totalPrice.add((item.getPrice()).multiply(new BigDecimal(item.getNum())));
		}
		return totalPrice;
	}

	// ��ȡ���ﳵ���������й��ﳵ�еĲ�Ʒ
	public List<CartItem> getItems() {
		return items;
	}

	// ��ȡ���ﳵ���������й��ﳵ�еĲ�Ʒ
	public CartItem getOneItems(String id) {
		for (CartItem item : items) { // �ж��Ƿ����и���Ʒ
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	// ������Ʒ���������
	public int getSize() {
		System.out.println(items.size());
		return items.size();
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
