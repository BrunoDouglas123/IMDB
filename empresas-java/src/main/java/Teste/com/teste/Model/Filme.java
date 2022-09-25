package Teste.com.teste.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "filme")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 90, nullable = false)
	private String nome;
	
	@Column(name = "genero", length = 90, nullable = false)
	private String genero;
	
	@Column(name = "ator", length = 90, nullable = false)
	private String ator;
	
	@Column(name = "diretor", length = 90, nullable = false)
	private String diretor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "filme")
	private List<Voto> votos = new ArrayList<>();
	
	public Filme() {		
	}

	public Filme(Long id, String nome, String genero, String ator, String diretor) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.ator = ator;
		this.diretor = diretor;
	}

	public Filme(String string) {
		// TODO Auto-generated constructor stub
	}

	public Filme(long l, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
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
	
	public List<Voto> getVotos() {
		return votos;
	}

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Filme statusCode(int value) {
		// TODO Auto-generated method stub
		return null;
	}
}
