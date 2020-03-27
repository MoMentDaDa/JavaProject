package Other_JavaBook;

import java.util.*;

public class ConversionDemo {

	public static void main(String[] args) {
//�����������asList����������ת��Ϊ���϶���
		Integer[] arrays= {11,22,33,44};
		List<Integer> list=Arrays.asList(arrays);
		System.out.println(list);
		//�õ�List����󻹿���ת��Ϊ�������͵ļ���
		List<Integer> arrayList=new ArrayList<>(list);
		System.out.println(arrayList);
		Set<Integer> hashSet=new HashSet<>(list);
		System.out.println(hashSet);
//������ת��Ϊ���飬ͨ��Collection�ӿ���toArray()�����������ַ�ʽ����
		System.out.println("----------------------");
		List<String> list2=new ArrayList<>();
		list2.add("44");
		list2.add("33");
		list2.add("22");
		list2.add("11");
		Object[] arrays2=list2.toArray();//ʹ��List����
		String[] arrays3=list2.toArray(new String[0]);//ʹ�÷��ͷ���
		for(String values:arrays3) {
			System.out.print(values);
		}
		System.out.println("----------------------");
		for(Object values:arrays2) {
			System.out.print(values);
		}
		
	}

}
