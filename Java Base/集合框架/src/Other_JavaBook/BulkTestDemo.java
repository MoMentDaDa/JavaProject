package Other_JavaBook;

import java.util.*;

//���ϵ���������
public class BulkTestDemo {
	final static Integer[] Data1 = { 11, 22, 33, 44, 55, 66 };
	final static Integer[] Data2 = { 11, 22, 77, 88 };

	static Set<Integer> getOriginalSet(Integer[] data) {
		Set<Integer> Set = new HashSet<Integer>(Arrays.asList(data));
		return Set;
	}

	static void print(Collection<Integer> col) {
		for (Integer i : col)
			System.out.println(i + "");
	}

	public static void main(String[] args) {
		Set<Integer> set1 = getOriginalSet(Data1);
		Set<Integer> set2 = getOriginalSet(Data2);
		set1.retainAll(set2);
		System.out.print("��ӡ�����ϼ�");
		print(set1);
		System.out.println("------------");

		Set<Integer> set3 = getOriginalSet(Data1);
		Set<Integer> set4 = getOriginalSet(Data2);
		set3.removeAll(set4);
		System.out.print("����ɾ��Ԫ��");
		print(set3);
		System.out.println("------------");

		Set<Integer> set5 = getOriginalSet(Data1);
		Set<Integer> set6 = getOriginalSet(Data2);
		set5.addAll(set6);
		System.out.print("�������Ԫ��");
		print(set5);
		System.out.println("------------");

		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(Data1));
		List<Integer> list2 = list1.subList(0, 3);
		list2.clear();
		System.out.print("ɾ�����б���ͼ���List�б�");
		print(list1);
		System.out.println("------------");

	}

}
