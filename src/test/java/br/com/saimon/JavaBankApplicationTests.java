package br.com.saimon;

import br.com.saimon.converter.DozerConverter;
import br.com.saimon.mocks.MockBank;
import br.com.saimon.model.entities.BankClientVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaBankApplicationTests {

	MockBank inputObject;

	@Before
	public void setUp(){
		inputObject = new MockBank();
	}

	@Test
	void parseEntityToVOTest () {
		BankClientVO output = DozerConverter.parseObject(inputObject.mockEntity(), BankClientVO.class);
		Assert.assertEquals("teste", output.getName());


	}

}
