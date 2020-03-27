package com.wang.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.Object.Client;
import com.wang.Params.LoginVO;

public interface ClientMapper {
	/* Mapper.xml中的id名称应该对应其相应dao中的方法名称 */
	// 方式一：将多个参数封装为VO,Mapper 参数类型应该接类的全限定名
	Client login1(LoginVO vo);

	// 方式二：使用Map进行封装参数，Mapper 文件#后接其Key
	Client login2(Map<String, Object> paramsMap);

	// 方式三：使用Map进行封装参数，注解中的字符串为Map中的Key，底层原理就是方式二
	Client login3(@Param("name") String username, @Param("password") String password);

	// 方式三：使用Map进行封装参数，注解中的字符串为Map中的Key，底层原理就是方式二
	Client login4(@Param("name") String username, @Param("password") String password);

	List<Client> list(@Param("orderby")String orderby);
}
