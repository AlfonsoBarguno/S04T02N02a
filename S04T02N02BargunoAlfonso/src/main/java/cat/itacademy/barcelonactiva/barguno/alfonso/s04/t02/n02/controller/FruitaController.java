package cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.domain.Fruita;
import cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.services.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

	@Autowired
	private FruitaService fruitaService;

	// Create a new Fruit
	@PostMapping ("/add")
	public ResponseEntity<?> add(@RequestBody Fruita fruita) {

		return ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.save(fruita));

	}

	@GetMapping("getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) {

		Optional<Fruita> opFruita = fruitaService.findById(id);

		if (!opFruita.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(opFruita);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> update (@RequestBody Fruita fruitaDetalles, @PathVariable int id){
		
		Optional<Fruita> opFruita = fruitaService.findById(id);
		
		if(!opFruita.isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		
		opFruita.get().setNom(fruitaDetalles.getNom());
		opFruita.get().setQuantitatQuilos(fruitaDetalles.getQuantitatQuilos());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.save(opFruita.get()));
}
	
	  @DeleteMapping("delete/{id}")
	  public ResponseEntity<?> delete (@PathVariable int id){
		  
		  if(!fruitaService.findById(id).isPresent()) {
			  
			  return ResponseEntity.notFound().build();
		  }
		  
		  fruitaService.deleteById(id);
		  return ResponseEntity.ok().build();
	  }
	  
	  @GetMapping("/getAll")
	  public List<Fruita> getAll(){
		  
		  List<Fruita> fruites = StreamSupport
				  .stream(fruitaService.findAll()
						  .spliterator(), false)
				  .collect(Collectors.toList());
		  
		  return fruites;
				  
				  
	  }
	  
}
