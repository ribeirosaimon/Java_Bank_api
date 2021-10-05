package br.com.saimon;

import br.com.saimon.mocks.CrudTest;
import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.model.repositories.ClientRepository;
import br.com.saimon.services.MovementExecutor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaBankApplicationTests {

	@Autowired
	ClientRepository clientRepository;

	CrudTest tests = new CrudTest();

	final BankClientVO new_user = tests.userCreateTest();
	final MovementExecutor movement = new MovementExecutor();

	@Test
	void entityInitTest() {
		Assert.assertEquals("name_test", new_user.getName());
		Assert.assertEquals("123", new_user.getAccount());
		Assert.assertEquals(0.0,
				new_user.getBalance(), 0);
		Assert.assertEquals(-200.0,new_user.getCheck_limit(),0);
	}

	@Test
	void entitywitdrawTest(){
		BankClientVO movementUser = movement.withdraw(new_user.getId(), 200.0);
		Assert.assertEquals(-200.0, movementUser.getBalance(), 0);
	}

}
