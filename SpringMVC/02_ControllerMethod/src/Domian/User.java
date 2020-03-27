package Domian;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String username;
	private Integer age;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")//设置时间格式，当使用DateUtils 类增强之后，就可以不用在每一个日期上面贴上注解啦，前台往后台
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//后台往前台相应
	private Date hiredate;//入职时间
}
