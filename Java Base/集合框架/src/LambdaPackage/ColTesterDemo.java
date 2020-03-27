package LambdaPackage;

import java.util.*;
import LambdaPackage.EachTesterDemo.Person;

public class ColTesterDemo {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>() {
			{//�������ʼ�������
				add(new Person("Tom", 21));
				add(new Person("Mke", 32));
				add(new Person("Linda", 19));
			}
		};
		persons.stream()
			.filter(p->p.getAge()>20)//��������Ϊ�������20
			.forEach(p->System.out.println(p.getName()+":"+p.getAge()));
		System.out.println("--------------");
		
		persons.stream()
			.sorted((p1,p2)->(p1.getAge()- p2.getAge()))//������������
			.limit(3)//ȡ��3��Ԫ��
			.forEach(p->System.out.println(p.getName()+":"+p.getAge()));
		System.out.println("--------------");
		
		
		int maxAge=persons.parallelStream()//��ò�����
				//�Ѱ����������ӳ��Ϊ��������������ֵ�int������
				.mapToInt(p->p.getAge())
				.max()//����������
				.getAsInt();
		System.out.println("Max Age:"+maxAge);

	}

}
