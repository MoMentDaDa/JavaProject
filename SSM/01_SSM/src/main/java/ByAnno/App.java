package ByAnno;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ByAnno.Domain.User;
import ByAnno.Mapper.userMapperDao;
import ByAnno.Service.userServiceDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc.xml")
public class App {

	@Autowired
	private userMapperDao userDao;

	// 这是代理对象
	@Autowired
	private userServiceDao userService;

	@Test
	public void testListAll() throws Exception {
		userDao.selectAll().forEach(System.out::println);
	}

	@Test
	public void testListAll2() throws Exception {
		userService.listAll().forEach(System.out::println);
	}

	@Test
	public void save() throws Exception {
		userService.save(new User(null, "", 11, new Date(), ""));
	}

}
