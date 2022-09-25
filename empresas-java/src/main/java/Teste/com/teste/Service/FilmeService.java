package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.FilmeDTO;
import Teste.com.teste.Model.Filme;
import Teste.com.teste.Repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	
	public List<FilmeDTO> findAll() {
		List<Filme> result = repository.findAll();
		return result.stream().map(x -> new
		FilmeDTO(x)).collect(Collectors.toList());
	}
	
	public Filme findById(Long id) {
		Optional<Filme> v = repository.findById(id);
		return v.get();
	}
	
	public Filme save(Filme Filme) {
		Filme v = repository.save(Filme);
		return v;
	}
	
	@Transactional
	public Filme update(Long id,Filme Filme) {
		Filme v = repository.getById(id);
		v.setId(id); 
		v.setNome(Filme.getNome());
		v.setGenero(Filme.getGenero());
		v.setAtor(Filme.getAtor());
		v.setDiretor(Filme.getDiretor());
		Filme vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
