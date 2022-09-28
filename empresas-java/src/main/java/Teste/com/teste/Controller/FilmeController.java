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

import Teste.com.teste.DTO.FilmeDTO;
import Teste.com.teste.Model.Filme;
import Teste.com.teste.Repository.FilmeRepository;
import Teste.com.teste.Service.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeRepository repository;
	
	@Autowired
	private FilmeService service;
	
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> findAll() {
		System.out.println("List of Users:");
		List<FilmeDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{page}")
	public ResponseEntity<Page<Filme>> findPage(Pageable pageable) {
		System.out.println("List of Users:");
		Page<Filme> list = repository.findPage(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<FilmeDTO> findById(@PathVariable Long id) {
		System.out.println("Movie: " + id);
		FilmeDTO v = new FilmeDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<FilmeDTO> findByName(@PathVariable String nome) {
		System.out.println("Movie: " + nome);
		FilmeDTO v = new FilmeDTO(service.findByName(nome));
		return ResponseEntity.ok(v);
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<FilmeDTO> findByGenero(@PathVariable String genero) {
		System.out.println("Movie with: " + genero);
		FilmeDTO v = new FilmeDTO(service.findByGenero(genero));
		return ResponseEntity.ok(v);
	}
	
	@GetMapping("/ator/{ator}")
	public ResponseEntity<FilmeDTO> findByAtor(@PathVariable String ator) {
		System.out.println("Movie with: " + ator);
		FilmeDTO v = new FilmeDTO(service.findByAtor(ator));
		return ResponseEntity.ok(v);
	}
	
	@GetMapping("/diretor/{diretor}")
	public ResponseEntity<FilmeDTO> findByDiretor(@PathVariable String diretor) {
		System.out.println("Movie with: " + diretor);
		FilmeDTO v = new FilmeDTO(service.findByDiretor(diretor));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Filme> save(@RequestBody Filme Filme) throws Exception {
		try {
			Filme save = service.save(Filme);
			System.out.println("New Movie Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filme> update(@PathVariable Long id,@RequestBody Filme Filme) {
		System.out.println("Movie " + id +" Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Filme));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("Movie " + id +" Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
