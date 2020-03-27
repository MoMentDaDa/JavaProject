package Other_JavaBook;

import java.util.*;

public class ConversionDemo {

	public static void main(String[] args) {
//运用数组类的asList方法将数组转换为集合对象
		Integer[] arrays= {11,22,33,44};
		List<Integer> list=Arrays.asList(arrays);
		System.out.println(list);
		//得到List对象后还可以转换为其他类型的集合
		List<Integer> arrayList=new ArrayList<>(list);
		System.out.println(arrayList);
		Set<Integer> hashSet=new HashSet<>(list);
		System.out.println(hashSet);
//将集合转换为数组，通过Collection接口中toArray()方法，有两种方式重载
		System.out.println("----------------------");
		List<String> list2=new ArrayList<>();
		list2.add("44");
		list2.add("33");
		list2.add("22");
		list2.add("11");
		Object[] arrays2=list2.toArray();//使用List方法
		String[] arrays3=list2.toArray(new String[0]);//使用泛型方法
		for(String values:arrays3) {
			System.out.print(values);
		}
		System.out.println("----------------------");
		for(Object values:arrays2) {
			System.out.print(values);
		}
		
	}

}
