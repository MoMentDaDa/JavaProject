package com.wang.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
