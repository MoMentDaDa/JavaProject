package com.wang.Domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Department {
	private Long id;
	private String name;
	//一个部门对应多个员工，建议先 new 出来，这样可以避免空指针和方便添加
	private List<Employee> emps=new ArrayList<Employee>();
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}