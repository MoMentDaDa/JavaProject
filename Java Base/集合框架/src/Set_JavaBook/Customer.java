package Set_JavaBook;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
//若把hasCode算法注释了，那么size值为2，反之为1，即为相同元素
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Set<Customer> set = new HashSet<Customer>();
		Customer customer1 = new Customer("Tom", 15);
		Customer customer2 = new Customer("Tom", 15);
		System.out.println(set.size());
		set.add(customer1);
		System.out.println(set);
		set.add(customer2);
		System.out.println(set.size());
		System.out.println(set);
	}

}
