package com.wang.MapperDao;

import com.wang.Domain.User;
import com.wang.Domain.UserExample;
import com.wang.Domain.UserKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(UserKey key);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(UserKey key);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	//在开发中，一个对象有多个字段，把对象中部分数据查询出来，转换成 JSON 格式字符串
	List<Map<String, Object>> listMap();
}