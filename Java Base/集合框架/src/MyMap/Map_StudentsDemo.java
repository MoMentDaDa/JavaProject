package MyMap;

import java.util.*;

public class Map_StudentsDemo {

	public static void main(String[] args) {
		// Set�����洢�༶
		Set<String> set1 = new HashSet<>();
		set1.add("��һ");
		set1.add("ٻ��");
		set1.add("����");
		Set<String> set2 = new HashSet<>();
		set2.add("�����");
		set2.add("��������");
		set2.add("����Ⱥ");
		set2.add("��ƽ");
		// Map�����洢�꼶
		Map<String, Set<String>> map1 = new HashMap<>();
		map1.put("ѧǰ��", set1);
		map1.put("�����", set2);
		Map<String, Set<String>> map2 = new HashMap<>();
		map2.put("ѧǰ��", set1);
		map2.put("�����", set2);
		// List�����洢ѧУ
		List<Map<String, Set<String>>> school = new ArrayList<>();
		school.add(map1);
		school.add(map2);
		System.out.println(school);
	}

}
