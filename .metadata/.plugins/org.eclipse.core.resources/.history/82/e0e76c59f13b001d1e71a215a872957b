package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.ModeloDTO;
import Teste.com.teste.Model.Marca;
import Teste.com.teste.Model.Modelo;
import Teste.com.teste.Repository.MarcaRepository;
import Teste.com.teste.Repository.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository repository;
	@Autowired
	private MarcaRepository marcrepository;
	
	public List<ModeloDTO> findAll() {
		List<Modelo>result = repository.findAll();
		return result.stream().map(x -> new ModeloDTO(x))
		.collect(Collectors.toList());
	}
	
	public Modelo findById(Long id) {
		Optional<Modelo> m = repository.findById(id);
		return m.get();
	}
	
	public Modelo save(Modelo modelo) {
			Marca marca = marcrepository.findById
			(modelo.getMarca().getId()).get();
			modelo.setMarca(marca);
			Modelo v = repository.save(modelo);
			return v;
		}
	@Transactional
	public Modelo update(Long id,Modelo modelo) {
		Modelo m = repository.getById(id);
		m.setId(id);
		m.setNome(modelo.getNome());
		m.setPreco(modelo.getPreco());
		m.setData(modelo.getData());
		Modelo mod = repository.save(m);
		return mod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
