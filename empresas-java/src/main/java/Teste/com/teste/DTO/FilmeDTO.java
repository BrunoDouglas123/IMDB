package Teste.com.teste.DTO;

import Teste.com.teste.Model.Filme;

public class FilmeDTO {
	
	private Long id;
	private String nome;
	private String genero;
	private String ator;
	private String diretor;
	
	private UsuarioDTO usuario;
	
	public FilmeDTO() {		
	}

	public FilmeDTO(Filme entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.genero = entity.getGenero();
		this.ator = entity.getAtor();
		this.diretor = entity.getDiretor();
		this.usuario = new UsuarioDTO(entity.getUsuario());
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
