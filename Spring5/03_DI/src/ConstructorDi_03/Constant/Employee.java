package ConstructorDi_03.Constant;

import java.math.BigDecimal;
import java.net.URL;

//需求：演示 setter 注入常量
public class Employee {
	private String name;
	private BigDecimal salary;
	private int age;

	public Employee(String name, BigDecimal salary, int age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

}
