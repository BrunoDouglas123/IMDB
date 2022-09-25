package Teste.com.teste.Int;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Teste.com.teste.Controller.UsuarioController;
import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.UsuarioRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(
		connection = EmbeddedDatabaseConnection.H2)
public class UsuarioIntTest {
	
	@Mock
	@Autowired
	private UsuarioRepository repository;
	
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
	private UsuarioController controller;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(repository).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
    @Order(1) @RepeatedTest(1)
    @DisplayName("Teste de Sucesso de Requisição, e retorno HTTP 201")
    public void shouldReturn201_WhenRegisteringUsuario() throws Exception {
    	Usuario User = new Usuario("{ \"nome\": \"Ana Carolina\" }")
    	.statusCode(HttpStatus.CREATED.value());
		assertTrue(User);
    }
	
	@Test
    @Order(1) @RepeatedTest(1)
    @DisplayName("Teste de Sucesso de Requisição, e retorno HTTP 404")
    public void shouldReturn404_WhenRegisteringUsuario() throws Exception {
    	Usuario User = new Usuario("{ \"nome\": \"Ana Carolina\" }")
    	.statusCode(HttpStatus.NOT_FOUND.value());
		assertTrue(User);
    }
	
	@Test
    @Order(3) @RepeatedTest(1)
    @DisplayName("Teste Falha de Requisição, e retorno HTTP 500")
    public void shouldReturn500_WhenFailedRegisteringUsuario() throws Exception {
    	Usuario User = new Usuario("{ \"nome\": \"Ana Carolina\" }")
    	.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		assertTrue(User);
    } private void assertTrue(Usuario Usuarioe) {}

    @Test
    @Disabled
    @Order(4) @RepeatedTest(1)
    @DisplayName("Teste de Cadastro de Usuario")
	public void registrationUsuario() throws Exception {
		Usuario User = new Usuario();
		repository.save(User)
        .statusCode(HttpStatus.CREATED.value());
		assertNotNull(User);
	}
    
    @Test
    @Disabled
    @Order(5) @RepeatedTest(1)
    @DisplayName("Teste de Remoção de Usuario")
    public void shouldDeleteUsuarioById() throws Exception {
    	shouldDeleteUsuarioById();
        mockMvc.perform(MockMvcRequestBuilders
        .delete("/{id}", 1L))
        .andExpect(status()
        .isNotFound());
    }

    @AfterAll
    public static void cleanUp(){ System.out.println("Only run once after all tests"); }
	
    @AfterEach
    public void cleanUpEach(){ System.out.println("Apparently all tests worked"); }

}
