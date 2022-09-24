package Teste.com.teste.DTO;

import java.time.LocalDate;

import Teste.com.teste.Model.Modelo;

public class ModeloDTO {
	
	private Long id;
	private String nome;
	private Double preco;
	private LocalDate data;
	
	private MarcaDTO marca;
	
	public ModeloDTO(Long id, String nome, Double preco, LocalDate data, MarcaDTO marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.data = data;
		this.marca = marca;
	}

	public ModeloDTO(Modelo entity) {
		id = entity.getId();
		nome = entity.getNome();
		preco = entity.getPreco();
		data = entity.getData();
		marca = new MarcaDTO(entity.getMarca());
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
}
