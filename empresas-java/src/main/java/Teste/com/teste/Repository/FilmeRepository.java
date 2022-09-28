package Teste.com.teste.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository <Filme, Long> {

	Page<Filme> findPage(Pageable pageable);

	Optional<Filme> findByName(String nome);
	
	Optional<Filme> findByGenero(String genero);
	
	Optional<Filme> findByAtor(String ator);
	
	Optional<Filme> findByDiretor(String diretor);

}
