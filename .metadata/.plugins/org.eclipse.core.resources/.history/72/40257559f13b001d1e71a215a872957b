package Teste.com.teste.DTO;

import java.io.Serializable;

import Teste.com.teste.Model.Marca;

public class MarcaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public MarcaDTO() {
	}

	public MarcaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public MarcaDTO(Marca entity) {
		id = entity.getId();
		nome = entity.getNome();
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
}
