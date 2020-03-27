package com.wang.Domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
	private long id;
	private String name;
	private List<Teacher> teachers = new ArrayList<>();
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}


	
}
