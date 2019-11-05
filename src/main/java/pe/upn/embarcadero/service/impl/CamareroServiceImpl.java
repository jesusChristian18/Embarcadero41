package pe.upn.embarcadero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upn.embarcadero.model.entity.Camarero;
import pe.upn.embarcadero.model.repository.CamareroRepository;
import pe.upn.embarcadero.service.CamareroService;

@Service
public class CamareroServiceImpl implements CamareroService{

	@Autowired
	private CamareroRepository camareroRepository;

	
	@Transactional(readOnly = true)
	@Override
	public List<Camarero> findAll() throws Exception {
		// TODO Auto-generated method stub
		return camareroRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Camarero> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return camareroRepository.findById(id);
	}

	@Transactional
	@Override
	public Camarero save(Camarero entity) throws Exception {
		// TODO Auto-generated method stub
		return camareroRepository.save(entity);
	}

	@Transactional
	@Override
	public Camarero update(Camarero entity) throws Exception {
		// TODO Auto-generated method stub
		return camareroRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		camareroRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		camareroRepository.deleteAll();
	}
	
	
}
