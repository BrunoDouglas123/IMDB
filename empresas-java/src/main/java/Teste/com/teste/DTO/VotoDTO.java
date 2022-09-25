package Teste.com.teste.DTO;

import Teste.com.teste.Model.Voto;

public class VotoDTO {
	
	private Long id;
	private int classificacao;
	
	private FilmeDTO filme;
	
	public VotoDTO() {
	}

	public VotoDTO(Voto entity) {
		this.id = entity.getId();
		this.classificacao = entity.getClassificacao();
		this.filme = new FilmeDTO(entity.getFilme());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public FilmeDTO getFilme() {
		return filme;
	}

	public void setFilme(FilmeDTO filme) {
		this.filme = filme;
	}
}
