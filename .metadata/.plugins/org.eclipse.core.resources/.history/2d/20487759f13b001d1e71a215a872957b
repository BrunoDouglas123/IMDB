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

import Teste.com.teste.DTO.ModeloDTO;
import Teste.com.teste.Model.Modelo;
import Teste.com.teste.Service.ModeloService;

@RestController
@RequestMapping(value = "/modelos")
public class ModeloController {
	
	@Autowired
	private ModeloService service;
	
	@GetMapping
	public ResponseEntity<List<ModeloDTO>> findAll() {
		System.out.println("List of Models:");
		List<ModeloDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModeloDTO> findById(@PathVariable Long id) {
		System.out.println("Model:");
		ModeloDTO m = new ModeloDTO(service.findById(id));
		return ResponseEntity.ok(m);
	}
	
	@PostMapping
	public ResponseEntity<ModeloDTO> save(@RequestBody Modelo modelo) {
		ModeloDTO m = new ModeloDTO(service.save(modelo));
		return ResponseEntity.ok(m);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Modelo> update(@PathVariable Long id,@RequestBody Modelo modelo) {
		System.out.println("Model Edited Sucessfully.");
		return ResponseEntity.ok(service.update(id, modelo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Model Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
