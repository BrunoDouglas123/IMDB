package Teste.com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Teste.com.teste.DTO.FilmeDTO;
import Teste.com.teste.Model.Filme;
import Teste.com.teste.Repository.FilmeRepository;
import Teste.com.teste.Service.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService service;
	
	@Autowired
	private FilmeRepository filmitory;
	
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> findAll() {
		System.out.println("List of Movies:");
		List<FilmeDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Filme>> findAll(Pageable pageable) throws Exception {
		try {
			Page<Filme> list = filmitory.findAll(pageable);
			return ResponseEntity.ok(list);
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FilmeDTO> findById(@PathVariable Long id) {
		System.out.println("Movie: " + id);
		FilmeDTO p = new FilmeDTO(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<FilmeDTO> save(@RequestBody Filme Filme) {
		System.out.println("New Movie Saved Sucessfully.");
		FilmeDTO p = new FilmeDTO(service.save(Filme));
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Filme> update(@PathVariable Long id,@RequestBody Filme Filme) {
		System.out.println("Movie " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Filme));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Movie " + id + " Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
