package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.VendedorDTO;
import Teste.com.teste.Model.Vendedor;
import Teste.com.teste.Repository.VendedorRepository;

//Service usa a Repository
//Responsavel por fazer a regra de negocio
@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;
	
	public List<VendedorDTO> findAll() {
		List<Vendedor> result = repository.findAll();
		return result.stream().map(x -> new
		VendedorDTO(x)).collect(Collectors.toList());
	}
	
	public Vendedor findById(Long id) {
		Optional<Vendedor> v = repository.findById(id);
		return v.get();
	}
	
	public Vendedor save(Vendedor vendedor) {
		Vendedor v = repository.save(vendedor);
		return v;
	}
	
	@Transactional
	public Vendedor update(Long id,Vendedor vendedor) {
		Vendedor v = repository.getById(id);
		v.setId(id); 
		v.setNome(vendedor.getNome());
		Vendedor vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
