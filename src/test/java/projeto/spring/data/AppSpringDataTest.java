package projeto.spring.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSrpingDataUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

	
	@Autowired ///faz a injecao de dependencias
	private InterfaceSrpingDataUser interfaceSpringDataUser;
	
	
	
	@Test
	public void testeInsert() {
		
		System.out.println("Iniciou com sucesso!");
		
		
	}
	
	
	
}
