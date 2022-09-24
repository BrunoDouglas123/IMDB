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

import Teste.com.teste.DTO.MarcaDTO;
import Teste.com.teste.Model.Marca;
import Teste.com.teste.Service.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaController {
	
	@Autowired
	private MarcaService service;
	
	@GetMapping
	public ResponseEntity<List<MarcaDTO>> findAll() {
		System.out.println("List of Brands:");
		List<MarcaDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MarcaDTO> findById(@PathVariable Long id) {
		System.out.println("Brand:");
		MarcaDTO m = new MarcaDTO(service.findById(id));
		return ResponseEntity.ok(m);
	}
	
	@PostMapping
	public ResponseEntity<Marca> save(@RequestBody Marca marca) {
		System.out.println("New Brand Saved Sucessfully.");
		return ResponseEntity.ok(service.save(marca));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Marca> update(@PathVariable Long id,@RequestBody Marca marca) {
		return ResponseEntity.ok(service.update(id, marca));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Brand Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
