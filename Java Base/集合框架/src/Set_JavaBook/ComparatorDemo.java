package Set_JavaBook;

import java.util.*;

public class ComparatorDemo implements Comparator<Customer> {
//����Comparator�ӿ�ʵ���Զ���Ƚ���������ʵ��ʱ�����ü���
	public static void main(String[] args) {
		Set<Customer> set = new TreeSet<>(new ComparatorDemo());
		Customer c1 = new Customer("Tom", 15);
		Customer c2 = new Customer("Jack", 16);
		Customer c3 = new Customer("MikeJackson", 17);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		System.out.println(set);
		// �������޸�������ֵ��Set����������������
		c3.setName("T");
		System.out.println(set);
	}

	public int compare(Customer c1, Customer c2) {
//�����ֳ��Ƚ�������
		if (c1.getName().length() > (c2.getName().length())) {
			return -1;
		} else if (c1.getName().length() < (c2.getName().length())) {
			return 1;
		}
		return 0;
	}
}
