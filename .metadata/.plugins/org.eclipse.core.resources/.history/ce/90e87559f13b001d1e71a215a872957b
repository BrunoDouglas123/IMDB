package Teste.com.teste.DTO;

import java.io.Serializable;

import Teste.com.teste.Model.Vendedor;

//DTO faz requisições,ou seja,restringe a quantidade de dados 
//para nem todos ficarem vulneravies,melhorando a segurança
public class VendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public VendedorDTO() {
	}

	public VendedorDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public VendedorDTO(Vendedor entity) {
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
