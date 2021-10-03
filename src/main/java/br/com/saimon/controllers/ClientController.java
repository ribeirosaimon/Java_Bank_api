package br.com.saimon.controllers;

import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account/v1")
public class ClientController {
	@Autowired
	private ClientServices service;

	@GetMapping
	public List<BankClientVO> findAllClient(){
		return service.findAllClient();
	}

	@GetMapping("/{id}")
	public BankClientVO findUser(@PathVariable("id") Long id){
		return service.findUser(id);
	}
	@PostMapping
	public BankClientVO create(@RequestBody BankClientVO user ){
		String user_name = user.getName();
		String user_password = user.getPassword();
		return service.createClient(user_name,user_password);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
