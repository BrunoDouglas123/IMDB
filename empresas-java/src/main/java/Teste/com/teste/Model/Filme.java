package Teste.com.teste.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Filme")
public class Filme implements Serializable {
	private static final long serialVersionUID = -5108788214274739225L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movie")
	private Long id;
	
	@Column(name = "nome", length = 90, nullable = false)
	private String nome;
	
	@Column(name = "genero", length = 90, nullable = false)
	private String genero;
	
	@Column(name = "ator", length = 90, nullable = false)
	private String ator;
	
	@Column(name = "diretor", length = 90, nullable = false)
	private String diretor;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Usuario usuario;
	
	public Filme() {		
	}

	public Filme(Long id, String nome, String genero, String ator, String diretor, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.ator = ator;
		this.diretor = diretor;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
