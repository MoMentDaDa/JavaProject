package Map_JavaBook;

import java.util.*;

//Map������������ظ�����������������ͨ��equals�Ƚ϶�Ϊfalse
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
		String day = map.get("2");// ȡ��Ϊ2��ֵ
		System.out.println(day);
		boolean a = map.containsKey("1");
		System.out.println("�Ƿ������Ϊ1��ֵ " + a + map.get("1"));
		boolean b = map.containsValue("Monday");
		System.out.println("�Ƿ����ֵΪMondya�ļ� " + b);
		System.out.println("----------------");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key);
			System.out.println(key + " " + value);
		}
		System.out.println("----------------");
		// ģ�����ͬ���������Mon�Ḳ��Monday
		map.put("1", "Mon");
		//��ȡMap������key��ϵļ��ϣ�Key�����ظ���������Set
		for (String key : keys) {
			String value = map.get(key);
			System.out.println(key + " " + value);
		}
		System.out.println("----------------");
		// ��ȡMap�����е�Entry(key-value),ʵ��map���ϱ���
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		for (Map.Entry<String, String> entry : entrys) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "<->" + value);
		}
		System.out.println("----------------");
		// ��ȡMap�����е�value����ɵļ��ϣ�value�����ظ���������List��
		Collection<String> g = map.values();
		for (Object val : g) {
			System.out.println(val);
		}
		System.out.println("----------------");
		//�Ƴ�ָ����Ԫ��
		map.remove("2");
		System.out.println(map); 
		System.out.println(map.size());
		map.clear();
		System.out.println(map.size());
		System.out.println(map.isEmpty());
	}

}
