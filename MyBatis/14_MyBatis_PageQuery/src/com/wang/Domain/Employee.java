package com.wang.Domain;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private int deptID = -1;

}
