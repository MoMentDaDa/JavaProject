package com.wang.Params;

import lombok.Data;

//封装适用于员工的高级查询的参数
@Data
public class EmployeeParams extends QueryObject {
	private Long deptId = -1L;// 部门ID,缺省为-1表示所有部门

	private String nameWord;
	public String getKeyword() {
		return emptyNull(nameWord);
	}
}
