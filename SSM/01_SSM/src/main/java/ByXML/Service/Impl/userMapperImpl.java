package ByXML.Service.Impl;

import java.util.List;

import ByXML.Domain.User;
import ByXML.Mapper.userMapperDao;
import ByXML.Service.userServiceDao;

public class userMapperImpl implements userServiceDao {

	private userMapperDao userMapper;

	public void setUserMapper(userMapperDao userMapper) {
		this.userMapper = userMapper;
	}

	public void save(User u) {
		userMapper.insert(u);
		//int i = 1 / 0;// 模拟事务管理
	}

	public void update(User u) {
		userMapper.updateById(u);
	}

	public void delete(Long id) {
		userMapper.deleteById(id);
	}

	public User get(Long id) {
		return userMapper.selectById(id);
	}

	public List<User> listAll() {
		return userMapper.selectAll();
	}
}