package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Voto;

@Repository
public interface VotoRepository extends JpaRepository <Voto, Long> {

}
