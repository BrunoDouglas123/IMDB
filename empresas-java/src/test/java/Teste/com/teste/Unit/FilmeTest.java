package Teste.com.teste.Unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
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

import Teste.com.teste.Model.Filme;
import Teste.com.teste.Repository.FilmeRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class FilmeTest {
	
	@Mock
	@Autowired
	private FilmeRepository repository;
	
	@Test
	@DisplayName("Teste da requisição POST")
	public void saveMovie() throws Exception {
		Filme Filme = new Filme(1L, "Inatividade Paranormal","Comedia","Marlon Wayans","Micahel Tiddes");
		repository.save(Filme);
		assertNotNull(Filme);
	}
	
	@Test
	@DisplayName("Teste da requisição GET")
	public void findByMovie() throws Exception {
		Filme Filme = new Filme
		(1L, "Inatividade Paranormal","Comedia","Marlon Wayans","Micahel Tiddes");
		List<Filme> Filmes = new ArrayList<>();
		Filmes.add(Filme);
	}
	
	@Test
	@DisplayName("Teste da requisição UPDATE")
    public void UpdateMovie() {
        Filme m = new Filme
        (1L, "Inatividade Paranormal","Comedia","Marlon Wayans","Micahel Tiddes");
        Filme save = repository.save(m);
        m.setNome("Inatividade Paranormal");
        save = repository.save(m);
        Assertions.assertEquals(save.getNome(), m.getNome());
    }
	
	@Test
	@DisplayName("Teste da requisição DELETE")
	public void deleteMovie() throws Exception {
		Filme Filme = new Filme(1L, "Inatividade Paranormal","Comedia","Marlon Wayans","Micahel Tiddes");
		repository.save(Filme);
		Long id = Filme .getId();
		boolean cli1 = repository.findById(id).isPresent();
		repository.deleteById(id);
		boolean cli2 = repository.findById(id).isPresent();
		assertTrue(cli1);
		assertFalse(cli2);
	}
}
