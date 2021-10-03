package br.com.saimon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.model.repositories.ClientRepository;

@Service
public class MovementExecutor {

	private ClientRepository clientRepository;

	@Autowired
	public MovementExecutor(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}


	public boolean withdraw(Long id, Double money) {
		BankClientVO user = clientRepository.findById(id).get();
		double balance = user.getBalance();
		double limit = user.getCheck_limit();
		if (balance > limit) {
			user.setBalance(balance -= money);
			clientRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean deposit(long id, double money) {
		BankClientVO user = clientRepository.findById(id).get();
		double balance = user.getBalance();
		user.setBalance(balance += money);
		clientRepository.save(user);
		return true;

	}
}
