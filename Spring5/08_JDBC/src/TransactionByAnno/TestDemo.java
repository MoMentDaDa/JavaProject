package TransactionByAnno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import TransactionByAnno.Service.AccountServiceDao;




@SpringJUnitConfig
class TestDemo {
	@Autowired
	private AccountServiceDao service;

	// 把1的钱转入给2
	@Test
	void testTrans() throws Exception {
		service.trans(1L, 2L, 100);
	}

	// 把2的钱转入给1
	@Test
	void testTrans2() throws Exception {
		service.trans(2L, 1l, 1100);
	}
}
