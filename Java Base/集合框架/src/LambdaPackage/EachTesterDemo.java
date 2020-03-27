package LambdaPackage;

import java.util.*;

public class EachTesterDemo {
	static class Person { //类必须为静态的，反之报错，因为主方法为静态的，主方法不能调用非静态方法
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>() {
			{//匿名类初始化代码块
				add(new Person("Tom", 21));
				add(new Person("Mke", 32));
				add(new Person("Linda", 19));
			}
		};
		persons.forEach((Person p) -> {//->后可执行代码相当于accept(T t)方法体
			// Lambda表达式，相当于是Consumer类型的匿名对象
			// 指定对每个元素的具体操作
			p.setAge(p.getAge()+1);
			System.out.println(p.getName() + ":" + p.getAge());
		});

	}
}
