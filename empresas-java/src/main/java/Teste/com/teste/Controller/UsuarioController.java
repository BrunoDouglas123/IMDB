package Teste.com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Teste.com.teste.DTO.UsuarioDTO;
import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.UsuarioRepository;
import Teste.com.teste.Service.UsuarioService;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		System.out.println("List of Users:");
		List<UsuarioDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		System.out.println("User: " + id);
		UsuarioDTO v = new UsuarioDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@GetMapping("/{page}")
	public ResponseEntity<Page<Usuario>> findPage(Pageable pageable) {
		System.out.println("List of Users:");
		Page<Usuario> list = repository.findPage(pageable);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario Usuario) throws Exception {
		try {
			Usuario save = service.save(Usuario);
			System.out.println("New User Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario Usuario) {
		System.out.println("User " + id +" Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("User " + id +" Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
