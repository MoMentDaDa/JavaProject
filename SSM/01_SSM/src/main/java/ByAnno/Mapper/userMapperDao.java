package ByAnno.Mapper;

import java.util.List;

import ByAnno.Domain.User;


public interface userMapperDao {
	/**
	 * 保存操作
	 * 
	 * @param u
	 * @return 返回受影响的行数
	 */
	int insert(User u);

	/**
	 * 根据id,更新操作
	 * 
	 * @param u
	 * @return 返回受影响的行数
	 */
	int updateById(User u);

	/**
	 * 删除操作
	 * 
	 * @param id
	 * @return 返回受影响的行数
	 */
	int deleteById(Long id);

	/**
	 * 根据指定id,查询单个对象操作
	 * 
	 * @param id
	 * @return 如果存在就返回该对象,否则返回null
	 */
	User selectById(Long id);

	/**
	 * 查询所有对象操作
	 * 
	 * @return
	 */
	List<User> selectAll();
}