package Teste.com.teste.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 4814048890204697430L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;
	
	@Column(name = "nome", length = 90, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 90, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 90, nullable = false)
	private String senha;
	
	@Column(name = "admin", length = 10, nullable = false)
	boolean admin;
		
	public Usuario() {		
	}

	public Usuario(Long id, String nome, String email, String senha, boolean admin) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.admin = admin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
