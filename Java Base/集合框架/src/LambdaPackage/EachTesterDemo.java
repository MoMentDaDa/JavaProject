package LambdaPackage;

import java.util.*;

public class EachTesterDemo {
	static class Person { //�����Ϊ��̬�ģ���֮������Ϊ������Ϊ��̬�ģ����������ܵ��÷Ǿ�̬����
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
			{//�������ʼ�������
				add(new Person("Tom", 21));
				add(new Person("Mke", 32));
				add(new Person("Linda", 19));
			}
		};
		persons.forEach((Person p) -> {//->���ִ�д����൱��accept(T t)������
			// Lambda���ʽ���൱����Consumer���͵���������
			// ָ����ÿ��Ԫ�صľ������
			p.setAge(p.getAge()+1);
			System.out.println(p.getName() + ":" + p.getAge());
		});

	}
}
