package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.UsuarioDTO;
import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usitory;
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> result = usitory.findAll();
		return result.stream().map(x -> new
		UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> v = usitory.findById(id);
		return v.get();
	}
	
	public Usuario save(Usuario Usuario) {
		Usuario v = usitory.save(Usuario);
		return v;
	}
	
	@Transactional
	public Usuario update(Long id,Usuario Usuario) {
		Usuario v = usitory.getById(id);
		v.setId(id); 
		v.setNome(Usuario.getNome());
		v.setEmail(Usuario.getEmail());
		v.setSenha(Usuario.getSenha());
		Usuario vendpt = usitory.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		usitory.deleteById(id);
	}
}
