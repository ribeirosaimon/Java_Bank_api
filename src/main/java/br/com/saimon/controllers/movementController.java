package br.com.saimon.controllers;

import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.services.ClientServices;
import br.com.saimon.services.MovementExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movement/v1")
public class movementController {
    @Autowired
    private MovementExecutor movementServices;
    @Autowired
    private ClientServices clientServices;


    @PostMapping("/{id}/deposit/{value}")
    public BankClientVO deposit(@PathVariable Long id, @PathVariable Double value){
        return movementServices.deposit(id, value);
    }

    @PostMapping("/{id}/withdraw/{value}")
    public BankClientVO withdraw(@PathVariable Long id, @PathVariable Double value){
        return movementServices.withdraw(id, value);
    }
}
