package projeto.spring.data;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSrpingDataUser;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

	
	@Autowired ///faz a injecao de dependencias
	private InterfaceSrpingDataUser interfaceSpringDataUser;
	
	
	
	@Test
	public void testeConsulta() {
		
		System.out.println("Iniciou com sucesso!");
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		System.out.println("O usuario cadastrado é " + usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		
		
		
	}
	
	
	@Test
	public void testeInsert() {
		
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("babe@gmail.com");
		usuarioSpringData.setIdade("34");
		usuarioSpringData.setLogin("user");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Babe");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		System.out.println("Usuarios cadastrados ---> " + interfaceSpringDataUser.count());
		
	}
	
	
	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for(UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("-------------------------------------");
			
			
			
		}
		
		
		
		
	}
	
}
