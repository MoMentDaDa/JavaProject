package LambdaPackage;

import java.util.*;
import LambdaPackage.EachTesterDemo.Person;

public class ColTesterDemo {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>() {
			{//匿名类初始化代码块
				add(new Person("Tom", 21));
				add(new Person("Mke", 32));
				add(new Person("Linda", 19));
			}
		};
		persons.stream()
			.filter(p->p.getAge()>20)//过滤条件为年龄大于20
			.forEach(p->System.out.println(p.getName()+":"+p.getAge()));
		System.out.println("--------------");
		
		persons.stream()
			.sorted((p1,p2)->(p1.getAge()- p2.getAge()))//按照年龄排序
			.limit(3)//取出3个元素
			.forEach(p->System.out.println(p.getName()+":"+p.getAge()));
		System.out.println("--------------");
		
		
		int maxAge=persons.parallelStream()//获得并行流
				//把包含对象的流映射为保存其年龄和名字的int类型流
				.mapToInt(p->p.getAge())
				.max()//获得最大年龄
				.getAsInt();
		System.out.println("Max Age:"+maxAge);

	}

}
