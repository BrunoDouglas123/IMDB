package Teste.com.teste.DTO;

import java.time.LocalDate;

import Teste.com.teste.Model.Produto;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private Double preco;
	private LocalDate venda;
	
	private VendedorDTO vendedor;

	public ProdutoDTO(Long id, String nome, Double preco, LocalDate venda, VendedorDTO vendedor) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.venda = venda;
		this.vendedor = vendedor;
	}
	
	public ProdutoDTO(Produto entity) {
		id = entity.getId();
		nome = entity.getNome();
		preco = entity.getPreco();
		venda = entity.getVenda();
		vendedor = new VendedorDTO(entity.getVendedor());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public LocalDate getVenda() {
		return venda;
	}

	public void setVenda(LocalDate venda) {
		this.venda = venda;
	}

	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
}
