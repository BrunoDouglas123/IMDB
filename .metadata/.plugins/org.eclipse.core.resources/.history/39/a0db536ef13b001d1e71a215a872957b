package Teste.com.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import Teste.com.teste.Model.Vendedor;
import Teste.com.teste.Repository.VendedorRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VendedorTest {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Test
	public void CreateSeller () {
		Vendedor vendedor = new Vendedor
		(1L, "Bruno", null);
		vendedorRepository.save(vendedor);
		assertNotNull(vendedor);
	}
	
	@Test
	public void SearchSeller () {
		Vendedor vendedor1 = new Vendedor
		(1L, "Bruno", null );
		Vendedor vendedor2 = new Vendedor
		(1L, "Karol", null);
		List<Vendedor> vendedores = new ArrayList<>();
		vendedores.add(vendedor1);
		vendedores.add(vendedor2);
	}
	
	@Test
	public void UpdateSeller () {
		String nome = "Karol";
		Vendedor Vendedor = new Vendedor
		(1L, "Bruno", null);
		vendedorRepository.save(Vendedor);
		Vendedor sel = vendedorRepository
		.findById(1L).get();
		sel.setNome(nome);
		Vendedor use = vendedorRepository
		.save(sel);
		assertEquals(use.getNome(),nome);
	}
	
	@Test
	public void DeleteSeller () {
		Vendedor vendedor = new Vendedor
		(1L, "Bruno", null);
		vendedorRepository.save(vendedor);
		Long id = vendedor.getId();
		boolean venda1 = vendedorRepository
		.findById(id).isPresent();
		vendedorRepository.deleteById(id);
		boolean venda2 = vendedorRepository
		.findById(id).isPresent();
		assertTrue(venda1);
		assertFalse(venda2);
	}
	
}
