package br.com.saimon.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.saimon.model.entities.BankClientVO;

public interface ClientRepository extends CrudRepository<BankClientVO, Long>{

}
