package ByAnno.Service;

import java.util.List;

import ByAnno.Domain.User;


public interface userServiceDao {
	void save(User u);

	void update(User u);

	void delete(Long id);

	User get(Long id);

	List<User> listAll();

}
