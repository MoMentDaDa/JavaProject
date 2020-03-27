package Map_JavaBook;

import java.util.*;

//Map不允许键对象重复，任意两个键对象通过equals比较都为false
public class MapTestDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		boolean c = map.isEmpty();
		System.out.println(c);
		map.put("1", "Monday");
		map.put("2", "Tuseday");
		map.put("3", "Wendsday");
		map.put("4", "Thursday");
		boolean d = map.isEmpty();
		System.out.println(d);
		String day = map.get("2");// 取键为2的值
		System.out.println(day);
		boolean a = map.containsKey("1");
		System.out.println("是否包含键为1的值 " + a + map.get("1"));
		boolean b = map.containsValue("Monday");
		System.out.println("是否包含值为Mondya的键 " + b);
		System.out.println("----------------");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key);
			System.out.println(key + " " + value);
		}
		System.out.println("----------------");
		// 模拟键相同情况，所以Mon会覆盖Monday
		map.put("1", "Mon");
		//获取Map中所有key组合的集合，Key不能重复，类似于Set
		for (String key : keys) {
			String value = map.get(key);
			System.out.println(key + " " + value);
		}
		System.out.println("----------------");
		// 获取Map中所有的Entry(key-value),实现map集合遍历
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		for (Map.Entry<String, String> entry : entrys) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "<->" + value);
		}
		System.out.println("----------------");
		// 获取Map中所有的value所组成的集合（value可以重复，类似于List）
		Collection<String> g = map.values();
		for (Object val : g) {
			System.out.println(val);
		}
		System.out.println("----------------");
		//移除指定键元素
		map.remove("2");
		System.out.println(map); 
		System.out.println(map.size());
		map.clear();
		System.out.println(map.size());
		System.out.println(map.isEmpty());
	}

}
