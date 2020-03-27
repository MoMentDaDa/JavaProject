package com.wang.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wang.Object.Client;

//使用注解开发
public interface ClientMapper {
	// 不使用注解，使用mapper.xml文件
	void save1(Client client);

	// 使用注解保存
	@Insert("insert into client (username,password) values (#{name},#{password})")
	@Options(useGeneratedKeys = true, keyProperty = "id") // 自动增长主键
	void save2(Client u);

	@Update("UPDATE client SET username= #{name} ,password = #{password} WHERE id = #{id}")
	void update(Client u);

	@Update("delete from client  WHERE id = #{id}")
	void delete(int id);

	@Select("select id,username,password from client where id=#{id}")
	@Results(id = "ClientResultMap", value = {
			@Result(column = "id", property = "id"),
			@Result(column = "username", property = "name"),
			@Result(column = "password", property = "password"),
			// 注释没有专门的主键ID,XML和注释只能选择其一，同时使用会冲突
	})
	Client get(int id);

	@Select("select id as u_id,username as u_name,password as u_password from client")
	@Results(id = "ClientResultMap2", value = {
			@Result(column = "u_id", property = "id"),
			@Result(column = "u_name", property = "name"),
			@Result(column = "u_password", property = "password"),
			// 注释没有专门的主键ID,XML和注释只能选择其一，同时使用会冲突
	})
	List<Client> listAll();

	List<Client> listAll2();

}
