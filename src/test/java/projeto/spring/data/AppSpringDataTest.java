package projeto.spring.data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSrpingDataUser;
import projeto.spring.data.dao.InterfaceTelefone;
import projeto.spring.data.model.Telefone;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired /// faz a injecao de dependencias
	private InterfaceSrpingDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;

	@Test
	public void testeConsulta() {

		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		System.out.println("O usuario cadastrado é " + usuarioSpringData.get().getNome());
		System.out.println("Email: " + usuarioSpringData.get().getEmail());
		System.out.println("Idade: " + usuarioSpringData.get().getIdade());
		
		 for (Telefone telefone :  usuarioSpringData.get().getTelefones()) {
			 System.out.println("Tipo: " + telefone.getTipo()+ " Numero: " + telefone.getNumero());
			 
			 
			 
		 };

	}

	@Test
	public void testeInsert() {

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("babe@gmail.com");
		usuarioSpringData.setIdade("34");
		usuarioSpringData.setLogin("user");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Fabio Teste ");

		interfaceSpringDataUser.save(usuarioSpringData);

		System.out.println("Usuarios cadastrados ---> " + interfaceSpringDataUser.count());

	}

	@Test
	public void testeConsultaTodos() {

		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : lista) {

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("-------------------------------------");

		}

	}
	
	@Test
	public void testeUpdate() {
		
	Optional<UsuarioSpringData> usuarioSpringData  = interfaceSpringDataUser.findById(3L);
	
	UsuarioSpringData data = usuarioSpringData.get();
	data.setNome("Juninho Spring Data Atualizado");
	interfaceSpringDataUser.save(data);
	
	System.out.println("O novo nome é ::" + usuarioSpringData.get().getNome() +" e o ID é "  +usuarioSpringData.get().getId());
		
	}
	
	@Test
	public void testeDelete() {
		
		/*DUAS FORMAS DE FAZER O DELETE FORMA 1*/
		interfaceSpringDataUser.deleteById(4L);
		System.out.println("Deletado");
		
		
		/*FORMA 2 PEGANDO A CONSULTA E DELETANDO UTILIZANDO interfaceSpringDataUser*/
		Optional<UsuarioSpringData> usuarioSpringData  = interfaceSpringDataUser.findById(4L);
		interfaceSpringDataUser.delete(usuarioSpringData.get());
		
		
		
	}
	
	
	@Test
	public void testeConsultaNome() {
		
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaporNome("Fabio");
		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("-------------------------------------");

		}
		
	}
	
	
	@Test
	public void testeConsultaNomeParam() {
		
		
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Fabio Verissimo");

			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("-------------------------------------");

		}
	
	
	@Test
	public void testedeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Fabio Teste Delete");
		System.out.println("Usuario deletado com sucesso!");
		
	}
	
	@Test
	public void testeupdatePorParametro() {
		interfaceSpringDataUser.updatePorParametro("jetsxxx@outlook.com", "Fabio Teste3");
		System.out.println("Email atualizado por parametro com sucesso!");
		
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		Telefone telefone = new Telefone();
		telefone.setNumero("90909099");
		telefone.setTipo("Celular");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		interfaceTelefone.save(telefone);
		
		
	}
		
	}
	


