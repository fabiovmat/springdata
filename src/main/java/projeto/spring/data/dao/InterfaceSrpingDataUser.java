package projeto.spring.data.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.model.UsuarioSpringData;

@Repository // ativa o servico de persistencia
public interface InterfaceSrpingDataUser extends CrudRepository<UsuarioSpringData, Long> { // passar o tipo de dados
																							// passado por ID
	@Transactional(readOnly = true)
	@Query(value = "SELECT p from UsuarioSpringData p WHERE p.nome like %?1%")
	public List<UsuarioSpringData> buscaporNome(String nome);

	/* passando a query por parametro */
	@Lock(LockModeType.READ)//impede que obj seja atualizado enquanto seja feita uma consulta
	@Transactional(readOnly = true)
	@Query(value = "SELECT p from UsuarioSpringData p WHERE p.nome = :paramnome")
	public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

	default <S extends UsuarioSpringData> S saveAtual(S entity) {
//usar este metodo para processar qualquer coisa antes de salvar no banco -- este metodo esta sobrescrevendo
		return save(entity);

	}
	
	/*DELETE CONDICIONAL*/
	@Modifying
	@Transactional
	@Query("delete from UsuarioSpringData u where u.nome = ?1") //?1 = 1 parametro
	public void deletePorNome(String nome);
	
	
	/*UPDATE CONDICIONAL*/
	@Modifying
	@Transactional
	@Query("update from UsuarioSpringData u set u.email = ?1 where u.nome = ?2") 
	public void updatePorParametro(String email, String nome);
	

}
