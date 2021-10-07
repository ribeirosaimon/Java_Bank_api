package br.com.saimon.services;

import br.com.saimon.converter.DozerConverter;
import br.com.saimon.exception.ClientNotFoundException;
import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.model.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ClientServices {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public BankClientVO createClient(String name, String password) {
        Random rand = new Random();
        BankClientVO user = new BankClientVO();
        Integer int_random = rand.nextInt(25);
        String str_random_number = int_random.toString();

        user.setName(name);
        user.setPassword(password);
        user.setAccount(str_random_number);
        user.setBalance(0);
        user.setCheck_limit(-200.0);
        var entity = DozerConverter.parseObject(user, BankClientVO.class);
        var vo = DozerConverter.parseObject(clientRepository.save(user), BankClientVO.class);
        return vo;
    }

    public BankClientVO findUser(long id) {
        return DozerConverter.parseObject(clientRepository.findById(id).get(), BankClientVO.class);
    }

    public List<BankClientVO> findAllClient() {
        List<BankClientVO> destinationObjects = new ArrayList<BankClientVO>();
        var clients = clientRepository.findAll();
        for (BankClientVO c : clients) {
            destinationObjects.add(c);
        }
        return DozerConverter.parseListObject(destinationObjects, BankClientVO.class);
    }

    public void delete(Long id) {
        BankClientVO user = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("No records found for this ID"));
        clientRepository.delete(user);
    }
}
