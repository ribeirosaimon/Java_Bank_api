package br.com.saimon.controllers;

import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.services.ClientServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/account/v1")
public class ClientController {
    @Autowired
    private ClientServices service;

    @GetMapping
    public List<BankClientVO> findAllClient() {
        return service.findAllClient();
    }

    @GetMapping("/{id}")
    public BankClientVO findUser(@PathVariable("id") Long id) {
        return service.findUser(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BankClientVO user) {
        try {
            String user_name = user.getName();
            String user_password = user.getPassword();
        } catch (DataIntegrityViolationException e) {
            ResponseEntity.badRequest().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
