package Set_JavaBook;
import java.util.*;
public class ComparableTestDemo {
	public static void main(String[] args) {
		// Set集对象不按特定方式排序，而且不允许有重复对象，会采用equals进行比较.若要复写，应该覆盖equals和hashCode方法
		Set<String> set=new HashSet<>();
		String s1=new String("Hello");
		String s2=new String("Hello");
		set.add(s1);
		set.add(s2);
		System.out.println(set.size());
		String s3=new String("world");
		String s4=new String("Java");
		String s5=new String("C++");
		set.add(s3);
		set.add(s4);
		set.add(s5);
		System.out.println(set.size());
		System.out.println(set);
		System.out.println("------------------------");
		// TreeSet会对添加数据进行自然排序，是通过Comparable接口，添加数据应为同一类型.反之报错ClassCastException.因为底层会进行Object转换
		Set<Integer> set1 = new TreeSet<>();
		set1.add(10);
		set1.add(8);
		set1.add(7);
		// set.add("10");
		System.out.println(set1);
		System.out.println("------------------------");
		// 利用泛型实现对ComparableDemo对象的存储，ComparableDemo类必须实现Comparable接口,对年龄进行排序
		Set<ComparableDemo> set2 = new TreeSet<ComparableDemo>();
		ComparableDemo ab=new ComparableDemo("Tom", 15);
		set2.add(ab);
		set2.add(new ComparableDemo("Mike", 10));
		set2.add(new ComparableDemo("Aliee", 88));
		System.out.println(set2.size());
		System.out.println(set2);
		//当程序修改其属性值后，Set集并不会重新排序
		ab.setAge(5);
		System.out.println(set2);
	}

}
