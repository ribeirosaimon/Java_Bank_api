package br.com.saimon.services;

import br.com.saimon.exception.BalanceMoneyException;
import br.com.saimon.exception.FailFindBankClientException;
import br.com.saimon.model.entities.BankClientVO;
import br.com.saimon.model.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovementExecutor {

	@Autowired
	private ClientRepository clientRepository;


	public BankClientVO findClientbyId(Long id){
	return clientRepository.findById(id).orElseThrow(() -> new FailFindBankClientException("ID not found"));
	}

	public BankClientVO withdraw(Long id, Double value){
		BankClientVO user = findClientbyId(id);
		return changeWithdrawBalance(user ,value ).orElseThrow(() -> new BalanceMoneyException("Not have money"));
	}
	private Optional<BankClientVO> changeWithdrawBalance(BankClientVO found_user, Double value){
			double balance = found_user.getBalance();
			double limit = found_user.getCheck_limit();
			if(balance - value >= limit){
				found_user.setBalance(balance -= value);
				clientRepository.save(found_user);
				return Optional.of(found_user);
			}
			return Optional.empty();
		}

	public BankClientVO deposit(long id, double money) {
		BankClientVO user = clientRepository.findById(id).get();
		double balance = user.getBalance();
		user.setBalance(balance += money);
		clientRepository.save(user);
		return user;

	}
}
