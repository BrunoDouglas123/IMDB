package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.FilmeDTO;
import Teste.com.teste.Model.Filme;
import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.FilmeRepository;
import Teste.com.teste.Repository.UsuarioRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	
	@Autowired
	private UsuarioRepository vendrepository;
	
	public List<FilmeDTO> findAll() {
		List<Filme>result = repository.findAll();
		return result.stream().map(x -> new 
		FilmeDTO(x)).collect(Collectors.toList());
	}
	
	public Filme findById(Long id) {
		Optional<Filme> p = repository.findById(id);
		return p.get();
	}
	
	public Filme save(Filme Filme) {
		Usuario Usuario = vendrepository.findById
		(Filme.getUsuario().getId()).get();
		Filme.setUsuario(Usuario);
		Filme v = repository.save(Filme);
		return v;
	}
	
	@Transactional
	public Filme update(Long id,Filme Filme) {
		Filme p = repository.getById(id);
		p.setId(id);
		p.setNome(Filme.getNome());
		p.setGenero(Filme.getGenero());
		p.setAtor(Filme.getAtor());
		Filme prod = repository.save(p);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
