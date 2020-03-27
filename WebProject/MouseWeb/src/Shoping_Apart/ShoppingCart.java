package Shoping_Apart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: ShoppingCart
 * @Description:购物车对对象
 * @author: 汪哒哒
 * @date: 2019年6月11日 下午4:29:02
 */
public class ShoppingCart {
	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	// 购物车中的多个商品对象
	private List<CartItem> items = new ArrayList<CartItem>();

	// 购物车的总价
	// private ToalPrice;

	// 把商品添加到购物车
	public void saveItem(CartItem newItem) {
		for (CartItem item : items) { // 判断是否已有该商品
			if (item.getId().equals(newItem.getId())) {
				item.setNum(item.getNum() + newItem.getNum());
				return;
			}
		}

		items.add(newItem);
	}


	
	// 从购物车中移除指定的商品
	public void delete(String id) {
		Iterator<CartItem> it = items.iterator();
		while (it.hasNext()) {
			CartItem item = it.next();
			if (item.getId().equals(id))
				;
			it.remove();
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

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + "]";
	}

	// 获取购物车链表中所有购物车中的产品
	public List<CartItem> getItems() {
		return items;
	}

	// 获取购物车链表中所有购物车中的产品
	public CartItem getOneItems(String id) {
		for (CartItem item : items) { // 判断是否已有该商品
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
}
