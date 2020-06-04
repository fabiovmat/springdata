package projeto.spring.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.model.UsuarioSpringData;

@Repository //ativa o servico de persistencia 
public interface InterfaceSrpingDataUser extends CrudRepository<UsuarioSpringData, Long> { //passar o tipo de dados passado por ID
	
@Query(value = "SELECT p from UsuarioSpringData p WHERE p.nome like %?1%")
public List<UsuarioSpringData> buscaporNome (String nome);

	

}
