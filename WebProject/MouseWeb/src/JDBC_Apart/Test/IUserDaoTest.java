package JDBC_Apart.Test;

import org.junit.jupiter.api.Test;

import JDBC_Apart.Dao.IUserDao;
import JDBC_Apart.Impl.UserImpl;

class IUserDaoTest {

	@Test
	void testGetlogin() {
		IUserDao dao=new UserImpl();
		System.out.println(	dao.getUserName("user").toString());
	}

}
