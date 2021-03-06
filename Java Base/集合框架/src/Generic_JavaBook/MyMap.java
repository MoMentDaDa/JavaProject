package Generic_JavaBook;

import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {// 第一个参数为Integer类型，第二个为String类型
//一个类可以有多个参数泛型
	private Map<K, V> map = new HashMap<K, V>();

	private void put(K k, V v) {
		map.put(k, v);

	}

	private V get(K k) {

		return map.get(k);
	}

	public int size() {
		return map.size();
	}

	// 接口也可定义为泛型接口
	public interface MyIFC<T1, T2, T3> {

	}

	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyMap<Integer, String>();
		map.put(1, "book1");
		map.put(2, "book2");
		System.out.println(map.get(2));// 获取map中索引为2的元素值
	}

}
