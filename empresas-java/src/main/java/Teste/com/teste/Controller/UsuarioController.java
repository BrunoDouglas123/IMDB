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
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() throws Exception {
		try {
			List<UsuarioDTO> list = service.findAll();
			System.out.println("List of Users:");
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Usuario>> findAll(Pageable pageable) throws Exception {
		try {
			Page<Usuario> cat = repository.findAll(pageable);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) throws Exception {
		try {
			UsuarioDTO v = new UsuarioDTO(service.findById(id));
			System.out.println("User: " + id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) throws Exception {
		try {
			Usuario save = service.save(usuario);
			System.out.println("New " + usuario + " Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario Usuario) throws Exception {
		try {
			System.out.println("User " + id + " Updated Sucessfully.");
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("User " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
