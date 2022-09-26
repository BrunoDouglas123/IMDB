package Teste.com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Teste.com.teste.DTO.VotoDTO;
import Teste.com.teste.Model.Voto;
import Teste.com.teste.Service.VotoService;

@RestController
@RequestMapping(value = "/votos")
public class VotoController {
	
	@Autowired
	private VotoService service;
	
	@GetMapping
	public ResponseEntity<List<VotoDTO>> findAll() {
		System.out.println("List of Votes:");
		List<VotoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VotoDTO> findById(@PathVariable Long id) {
		System.out.println("Vote: " + id);
		VotoDTO p = new VotoDTO(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<VotoDTO> save(@RequestBody Voto Voto) {
		System.out.println("New Product Saved Sucessfully.");
		VotoDTO p = new VotoDTO(service.save(Voto));
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Voto> update(@PathVariable Long id,@RequestBody Voto Voto) {
		System.out.println("Vote " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Voto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Vote " + id + " Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
