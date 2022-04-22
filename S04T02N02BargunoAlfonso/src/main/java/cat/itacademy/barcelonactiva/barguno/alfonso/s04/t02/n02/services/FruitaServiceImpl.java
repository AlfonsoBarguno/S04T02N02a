package cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.domain.Fruita;
import cat.itacademy.barcelonactiva.barguno.alfonso.s04.t02.n02.repository.FruitaRepository;

@Service
public class FruitaServiceImpl implements FruitaService {

	
	@Autowired
	private FruitaRepository fruitaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Fruita> findAll() {
	
		
		return fruitaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Fruita> findAll(Pageable pageable) {
		
		return fruitaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Fruita> findById(int id) {
		
		return fruitaRepository.findById(id);
	}

	@Override
	@Transactional
	public Fruita save(Fruita fruita) {
		
		return fruitaRepository.save(fruita);
	}

	@Override
	@Transactional
	public void deleteById(int id) {

		fruitaRepository.deleteById(id);
	}

}
