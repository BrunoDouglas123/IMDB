package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.ProdutoDTO;
import Teste.com.teste.Model.Produto;
import Teste.com.teste.Model.Vendedor;
import Teste.com.teste.Repository.ProdutoRepository;
import Teste.com.teste.Repository.VendedorRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private VendedorRepository vendrepository;
	
	public List<ProdutoDTO> findAll() {
		List<Produto>result = repository.findAll();
		return result.stream().map(x -> new 
		ProdutoDTO(x)).collect(Collectors.toList());
	}
	
	public Produto findById(Long id) {
		Optional<Produto> p = repository.findById(id);
		return p.get();
	}
	
	public Produto save(Produto produto) {
		Vendedor vendedor = vendrepository.findById
		(produto.getVendedor().getId()).get();
		produto.setVendedor(vendedor);
		Produto v = repository.save(produto);
		return v;
	}
	
	@Transactional
	public Produto update(Long id,Produto produto) {
		Produto p = repository.getById(id);
		p.setId(id);
		p.setNome(produto.getNome());
		p.setPreco(produto.getPreco());
		p.setVenda(produto.getVenda());
		Produto prod = repository.save(p);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
