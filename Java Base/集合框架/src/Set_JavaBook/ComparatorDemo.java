package Set_JavaBook;

import java.util.*;

public class ComparatorDemo implements Comparator<Customer> {
//利用Comparator接口实现自定义比较器，创建实例时，调用即可
	public static void main(String[] args) {
		Set<Customer> set = new TreeSet<>(new ComparatorDemo());
		Customer c1 = new Customer("Tom", 15);
		Customer c2 = new Customer("Jack", 16);
		Customer c3 = new Customer("MikeJackson", 17);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		System.out.println(set);
		// 当程序修改其属性值后，Set集并不会重新排序
		c3.setName("T");
		System.out.println(set);
	}

	public int compare(Customer c1, Customer c2) {
//按名字长度进行排序
		if (c1.getName().length() > (c2.getName().length())) {
			return -1;
		} else if (c1.getName().length() < (c2.getName().length())) {
			return 1;
		}
		return 0;
	}
}
