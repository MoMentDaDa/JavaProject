package Set_JavaBook;
import java.util.*;
public class ComparableTestDemo {
	public static void main(String[] args) {
		// Set�����󲻰��ض���ʽ���򣬶��Ҳ��������ظ����󣬻����equals���бȽ�.��Ҫ��д��Ӧ�ø���equals��hashCode����
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
		// TreeSet���������ݽ�����Ȼ������ͨ��Comparable�ӿڣ��������ӦΪͬһ����.��֮����ClassCastException.��Ϊ�ײ�����Objectת��
		Set<Integer> set1 = new TreeSet<>();
		set1.add(10);
		set1.add(8);
		set1.add(7);
		// set.add("10");
		System.out.println(set1);
		System.out.println("------------------------");
		// ���÷���ʵ�ֶ�ComparableDemo����Ĵ洢��ComparableDemo�����ʵ��Comparable�ӿ�,�������������
		Set<ComparableDemo> set2 = new TreeSet<ComparableDemo>();
		ComparableDemo ab=new ComparableDemo("Tom", 15);
		set2.add(ab);
		set2.add(new ComparableDemo("Mike", 10));
		set2.add(new ComparableDemo("Aliee", 88));
		System.out.println(set2.size());
		System.out.println(set2);
		//�������޸�������ֵ��Set����������������
		ab.setAge(5);
		System.out.println(set2);
	}

}
