package ByAnno.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ByAnno.Domain.User;
import ByAnno.Mapper.userMapperDao;
import ByAnno.Service.userServiceDao;

@Service
@Transactional
public class userMapperImpl implements userServiceDao {
	@Autowired
	private userMapperDao userMapper;

	// @Transactional(readOnly = true) 模拟事务管理器
	public void save(User u) {
		userMapper.insert(u);
		// int i = 1 / 0;// 模拟事务管理
	}

	public void update(User u) {
		userMapper.updateById(u);
	}

	public void delete(Long id) {
		userMapper.deleteById(id);
	}

	@Transactional(readOnly = true)
	public User get(Long id) {
		return userMapper.selectById(id);
	}

	@Transactional(readOnly = true)
	public List<User> listAll() {
		return userMapper.selectAll();
	}
}
