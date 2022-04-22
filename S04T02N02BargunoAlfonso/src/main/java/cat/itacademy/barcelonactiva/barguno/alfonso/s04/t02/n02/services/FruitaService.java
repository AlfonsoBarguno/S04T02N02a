package cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.domain.Fruita;

public interface FruitaService {
	
	public Iterable<Fruita> findAll();
	
	public Page<Fruita> findAll(Pageable pageable);
	
	public Optional<Fruita> findById (int id);
	
	public Fruita save(Fruita fruita);
	
	public void deleteById (int id);

}
