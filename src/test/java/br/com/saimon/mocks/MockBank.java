package br.com.saimon.mocks;

import br.com.saimon.model.entities.BankClientVO;

import java.util.ArrayList;
import java.util.List;

public class MockBank {

    private BankClientVO mockEntity(Integer number){
        BankClientVO user = new BankClientVO();
        user.setAccount("123");
        user.setName("name_test");
        user.setBalance(0);
        user.setCheck_limit(-200);
        return user;
    }

    public List<BankClientVO> mockVOList(){
        List<BankClientVO> users = new ArrayList<BankClientVO>();
        for (int i = 0; i < 5;i++){
            users.add(mockEntity(i));
        }
        return users;
    }

    public BankClientVO mockEntity(){
        return mockEntity(0);
    }

}
