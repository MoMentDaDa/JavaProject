package MySet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashSetDemo {

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("C");
		set.add("A");
		set.add("1");
		set.add("D");
		set.add("0");
		set.add("O");
		System.out.println(set);//无序，打印出[0, A, 1, C, D, O]
		Set<String> set2=new HashSet<>();
		set2.add("8");
		set2.add("9");
		set.addAll(set2);
		System.out.println(set);//[0, A, 1, 2, C, D, O]
		//使用for循环输出集合
		for(String ele:set) {
			System.out.print(ele);
		}
		System.out.println("----------");
		//使用迭代器遍历输出集合，但只能执行一次。因为指针已经到集合尾部
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		set.remove("A");//移除A
		System.out.println(set);
		System.out.println(set.contains("D"));//检索是否存在特定元素
		System.out.println(set.size());
		set.removeAll(set2);//使用Collection接口方法移除set2的元素
		System.out.println(set);
		set.clear();
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		
		
	}

}
