package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.MarcaDTO;
import Teste.com.teste.Model.Marca;
import Teste.com.teste.Repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	public List<MarcaDTO> findAll() {
		List<Marca>result = repository.findAll();
		return result.stream().map(x -> new 
		MarcaDTO(x)).collect(Collectors.toList());
	}
	
	public Marca findById(Long id) {
		Optional<Marca> m = repository.findById(id);
		return m.get();
	}
	
	public Marca save(Marca marca) {
		Marca m = repository.save(marca);
		return m;
	}
	
	@Transactional
	public Marca update(Long id,Marca marca) {
		Marca m = repository.getById(id);
		m.setId(id); 
		m.setNome(marca.getNome());
		Marca marc = repository.save(m);
		return marc;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
