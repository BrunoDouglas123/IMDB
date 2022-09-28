package Teste.com.teste.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	Page<Usuario> findPage(Pageable pageable);

}
