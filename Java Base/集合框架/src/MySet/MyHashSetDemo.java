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
		System.out.println(set);//���򣬴�ӡ��[0, A, 1, C, D, O]
		Set<String> set2=new HashSet<>();
		set2.add("8");
		set2.add("9");
		set.addAll(set2);
		System.out.println(set);//[0, A, 1, 2, C, D, O]
		//ʹ��forѭ���������
		for(String ele:set) {
			System.out.print(ele);
		}
		System.out.println("----------");
		//ʹ�õ���������������ϣ���ֻ��ִ��һ�Ρ���Ϊָ���Ѿ�������β��
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		set.remove("A");//�Ƴ�A
		System.out.println(set);
		System.out.println(set.contains("D"));//�����Ƿ�����ض�Ԫ��
		System.out.println(set.size());
		set.removeAll(set2);//ʹ��Collection�ӿڷ����Ƴ�set2��Ԫ��
		System.out.println(set);
		set.clear();
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		
		
	}

}
