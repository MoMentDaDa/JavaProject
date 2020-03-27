package Anno.IoC;

import org.springframework.stereotype.Component;

import lombok.Data;
//使用 @Component 注解取代 XML 配置，同时应该在 XML 中配置 IoC 解析器，不写注解的属性值，默认为 bean 类型的首字母小写
@Data
@Component("xxds")
public class Person {
	

}
