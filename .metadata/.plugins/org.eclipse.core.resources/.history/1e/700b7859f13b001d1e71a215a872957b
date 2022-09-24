package Teste.com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import Teste.com.teste.DTO.VendedorDTO;
import Teste.com.teste.Model.Vendedor;
import Teste.com.teste.Service.VendedorService;

//Video Marcelo (https://www.instagram.com/p/CQEW7BMnSr3/)
//Controller usa a Service,não usa a Repository
@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorService service;
	
	@GetMapping
	public ResponseEntity<List<VendedorDTO>> findAll() {
		System.out.println("List of Sellers:");
		List<VendedorDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VendedorDTO> findById(@PathVariable Long id) {
		System.out.println("Seller:");
		VendedorDTO v = new VendedorDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Vendedor> save(@RequestBody Vendedor vendedor) throws Exception {
		try {
			Vendedor save = service.save(vendedor);
			System.out.println("New Seller Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vendedor> update(@PathVariable Long id,@RequestBody Vendedor vendedor) {
		return ResponseEntity.ok(service.update(id, vendedor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("Seller Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
