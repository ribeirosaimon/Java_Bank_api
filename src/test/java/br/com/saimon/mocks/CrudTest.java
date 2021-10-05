package br.com.saimon.mocks;

import br.com.saimon.model.entities.BankClientVO;

public class CrudTest {

    public BankClientVO userCreateTest(){
        BankClientVO user = new BankClientVO();
        user.setAccount("123");
        user.setName("name_test");
        user.setBalance(0.0);
        user.setCheck_limit(-200.0);
        return user;
    }
}
