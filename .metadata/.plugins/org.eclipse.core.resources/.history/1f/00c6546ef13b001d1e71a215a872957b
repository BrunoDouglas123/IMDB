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

import Teste.com.teste.Model.Produto;
import Teste.com.teste.Repository.ProdutoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProdutoTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void CreateProduct () {
		Produto produto = new Produto
		(1L, "Tenis1", null, null, null);
		produtoRepository.save(produto);
		assertNotNull(produto);
	}
	
	@Test
	public void SearchProduct () {
		Produto produto1 = new Produto
		(1L, "Tenis1", null, null, null );
		Produto produto2 = new Produto
		(1L, "Tenis2", null, null, null);
		List<Produto> produtos = new ArrayList<>();
		produtos.add(produto1);
		produtos.add(produto2);
	}
	
	@Test
	public void UpdateProduct () {
		String nome = "Karol";
		Produto Produto = new Produto
		(1L, "Bruno", null, null, null);
		produtoRepository.save(Produto);
		Produto sel = produtoRepository
		.findById(1L).get();
		sel.setNome(nome);
		Produto use = produtoRepository
		.save(sel);
		assertEquals(use.getNome(),nome);
	}
	
	@Test
	public void DeleteSeller () {
		Produto produto = new Produto
		(1L, "Bruno", null, null, null);
		produtoRepository.save(produto);
		Long id = produto.getId();
		boolean venda1 = produtoRepository
		.findById(id).isPresent();
		produtoRepository.deleteById(id);
		boolean venda2 = produtoRepository
		.findById(id).isPresent();
		assertTrue(venda1);
		assertFalse(venda2);
	}
}
