package LambdaPackage;

import java.util.*;
public class SortTesterDemo {
	public static void main(String[] args) {
		String[] data = { "Tom", "Mike", "Mary", "Linda", "Jack" };
		List<String> names = Arrays.asList(data);
//���������ڲ���ʵ��ʵ������
		Comparator<String> cp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s1.compareTo(s2));
			}
		};
		Collections.sort(names, cp);
//��Lambda���ʽ������
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		Collections.sort(names, sortByName);
//��Lambda���ʽ������
		Collections.sort(names, (String s1, String s2) -> (s1.compareTo(s2)));
		names.forEach(System.out::println);
	}

}
