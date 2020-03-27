package Set_JavaBook;

public class ComparableDemo implements Comparable<ComparableDemo> {

	private String name;
	private int age;

	public ComparableDemo(String name, int age) {
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

//实现Comparable方法接口进行特内部排序
	public int compareTo(ComparableDemo o) {
		// 再按age属性排序
		if (this.age > o.getAge()) {
			return 1;
		} else if (this.age < o.getAge()) {
			return -1;
		}
		return 0;
	}

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
		ComparableDemo other = (ComparableDemo) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "[name=" + name + ",age=" + age + "]";
	}
}
