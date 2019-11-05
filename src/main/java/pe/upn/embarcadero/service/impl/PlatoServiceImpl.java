package pe.upn.embarcadero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upn.embarcadero.model.entity.Plato;
import pe.upn.embarcadero.model.repository.PlatoRepository;
import pe.upn.embarcadero.service.PlatoService;

@Service
public class PlatoServiceImpl implements PlatoService {

	@Autowired
	private PlatoRepository platoRepository;

	
	@Transactional(readOnly = true)
	@Override
	public List<Plato> findAll() throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Plato> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.findById(id);
	}

	@Transactional
	@Override
	public Plato save(Plato entity) throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.save(entity);
	}

	@Transactional
	@Override
	public Plato update(Plato entity) throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		platoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		platoRepository.deleteAll();
	}
	
	
}
