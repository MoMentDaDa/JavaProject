package SetterDi_02.Constant;

import java.math.BigDecimal;
import java.net.URL;
//需求：演示 setter 注入常量
public class Employee {
	private String name;
	private BigDecimal salary;
	private int age;
	private URL url;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + ", url=" + url + "]";
	}


}
