package projeto.spring.data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.model.UsuarioSpringData;

@Repository //ativa o servico de persistencia 
public interface InterfaceSrpingDataUser extends CrudRepository<UsuarioSpringData, Long> { //passar o tipo de dados passado por ID
	
	
	
	

}
