package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository <Filme, Long> {

}
