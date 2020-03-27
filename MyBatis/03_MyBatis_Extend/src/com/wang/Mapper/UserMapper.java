package com.wang.Mapper;

import java.util.List;

import com.wang.Object.User;

public interface UserMapper {
	/* Mapper.xml中的id名称应该对应其相应dao中的方法名称 */
	void save(User u);

	void update(User u);

	void delete(int id);

	User get(int id);

	List<User> listAll();

}
