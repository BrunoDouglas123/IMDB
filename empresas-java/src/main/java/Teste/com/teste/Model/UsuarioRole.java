package Teste.com.teste.Model;

import org.springframework.security.core.GrantedAuthority;

public enum UsuarioRole implements GrantedAuthority {
	
	ROLE_ADMIN, ROLE_CLIENT;

	public String getAuthority() {
		return name();
	}
}
