package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.VotoDTO;
import Teste.com.teste.Model.Filme;
import Teste.com.teste.Model.Voto;
import Teste.com.teste.Repository.FilmeRepository;
import Teste.com.teste.Repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository repository;

	@Autowired
	private FilmeRepository vendrepository;
	
	public List<VotoDTO> findAll() {
		List<Voto>result = repository.findAll();
		return result.stream().map(x -> new 
		VotoDTO(x)).collect(Collectors.toList());
	}
	
	public Voto findById(Long id) {
		Optional<Voto> p = repository.findById(id);
		return p.get();
	}
	
	public Voto save(Voto Voto) {
		Filme Filme = vendrepository.findById
		(Voto.getFilme().getId()).get();
		Voto.setFilme(Filme);
		Voto v = repository.save(Voto);
		return v;
	}
	
	@Transactional
	public Voto update(Long id,Voto Voto) {
		Voto p = repository.getById(id);
		p.setId(id);
		p.setClassificacao(Voto.getClassificacao());
		Voto prod = repository.save(p);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
