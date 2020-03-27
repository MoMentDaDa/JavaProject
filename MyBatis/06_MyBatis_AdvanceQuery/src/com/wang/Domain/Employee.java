package com.wang.Domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private String sn;
	private BigDecimal salary;
	private int deptID;

	public Employee(String name, String sn, int ID) {
		this.name = name;
		this.sn = sn;
		this.deptID = ID;
	}

}
