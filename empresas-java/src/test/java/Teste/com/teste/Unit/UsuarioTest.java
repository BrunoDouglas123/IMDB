package Teste.com.teste.Unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.UsuarioRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UsuarioTest {
	
	@Mock
	@Autowired
	private UsuarioRepository repository;
	
	@Test
	@DisplayName("Teste da requisição POST")
	public void saveMovie() throws Exception {
		Usuario Usuario = new Usuario(1L, "Ana Carolina", "blabla240@gmail", "12345678");
		repository.save(Usuario);
		assertNotNull(Usuario);
	}
	
	@Test
	@DisplayName("Teste da requisição GET")
	public void findByMovie() throws Exception {
		Usuario Usuario = new Usuario
		(1L, "Ana Carolina", "blabla240@gmail", "12345678");
		List<Usuario> Usuarios = new ArrayList<>();
		Usuarios.add(Usuario);
	}
	
	@Test
	@DisplayName("Teste da requisição UPDATE")
	public void updateUsuario () throws Exception {
		String name = "Ana Carolina";
		Usuario User = new Usuario(1L, "Ana Carolina", "blabla240@gmail", "12345678");
		repository.save(User);
		Usuario Usuario = repository.findById(1L).get();
		Usuario.setNome(name);
		Usuario liga = repository.save(Usuario);
		assertEquals(liga.getNome(),name);
	}
	
	@Test
	@DisplayName("Teste da requisição DELETE")
	public void deleteMovie() throws Exception {
		Usuario User = new Usuario(1L, "Ana Carolina", "blabla240@gmail", "12345678");
		repository.save(User);
		Long id = User .getId();
		boolean cli1 = repository.findById(id).isPresent();
		repository.deleteById(id);
		boolean cli2 = repository.findById(id).isPresent();
		assertTrue(cli1);
		assertFalse(cli2);
	}
}
