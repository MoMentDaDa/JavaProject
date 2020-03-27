package ByAnno.Domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

	private Long id; // 唯一标识
	private String name; // 名字
	private Integer age; // 年龄
	private Date bornDate;// 出生日期
	private String headImg;
}
