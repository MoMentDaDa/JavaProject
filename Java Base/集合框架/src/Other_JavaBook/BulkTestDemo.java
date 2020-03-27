package Other_JavaBook;

import java.util.*;

//集合的批量操作
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
		System.out.print("打印两集合集");
		print(set1);
		System.out.println("------------");

		Set<Integer> set3 = getOriginalSet(Data1);
		Set<Integer> set4 = getOriginalSet(Data2);
		set3.removeAll(set4);
		System.out.print("批量删除元素");
		print(set3);
		System.out.println("------------");

		Set<Integer> set5 = getOriginalSet(Data1);
		Set<Integer> set6 = getOriginalSet(Data2);
		set5.addAll(set6);
		System.out.print("批量添加元素");
		print(set5);
		System.out.println("------------");

		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(Data1));
		List<Integer> list2 = list1.subList(0, 3);
		list2.clear();
		System.out.print("删除子列表视图后的List列表");
		print(list1);
		System.out.println("------------");

	}

}
