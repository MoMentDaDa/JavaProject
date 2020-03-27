package MyMap;

import java.util.*;

public class Map_StudentsDemo {

	public static void main(String[] args) {
		// Set用来存储班级
		Set<String> set1 = new HashSet<>();
		set1.add("赵一");
		set1.add("倩儿");
		set1.add("孙三");
		Set<String> set2 = new HashSet<>();
		set2.add("令狐冲");
		set2.add("东方不败");
		set2.add("岳不群");
		set2.add("林平");
		// Map用来存储年级
		Map<String, Set<String>> map1 = new HashMap<>();
		map1.put("学前班", set1);
		map1.put("大神班", set2);
		Map<String, Set<String>> map2 = new HashMap<>();
		map2.put("学前班", set1);
		map2.put("大神班", set2);
		// List用来存储学校
		List<Map<String, Set<String>>> school = new ArrayList<>();
		school.add(map1);
		school.add(map2);
		System.out.println(school);
	}

}
